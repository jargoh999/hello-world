package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.Order;
import com.semicolon.africa.zoomlogistics.data.models.OrderHistory;
import com.semicolon.africa.zoomlogistics.data.models.OrderStatus;
import com.semicolon.africa.zoomlogistics.data.models.User;
import com.semicolon.africa.zoomlogistics.dto.*;
import com.semicolon.africa.zoomlogistics.exceptions.OrderNotFoundExp;
import com.semicolon.africa.zoomlogistics.exceptions.UserDoesNotExistException;
import com.semicolon.africa.zoomlogistics.repository.Addresses;
import com.semicolon.africa.zoomlogistics.repository.OrderHistoryRepository;
import com.semicolon.africa.zoomlogistics.repository.Orders;
import com.semicolon.africa.zoomlogistics.repository.Users;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.semicolon.africa.zoomlogistics.utils.Mappers.mapOrderToResponse;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private Users users;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private OrderServicesImpl orderServices;
    @Autowired
    private ItemServicesImpl itemServices;
    @Autowired
    private AddressServicesImpl addressServices;
    @Autowired
    private Orders orders;
    @Autowired
    private Addresses addresses;

    @Override
    public User findUsersById(Long id) {
        return users.findUserById(id);
    }
    @Override
    public LogInResponse logIn(LoginRequest request) {
            var user =users.findUsersByUsername(request.getUsername().toLowerCase());
            if(user == null)throw new UserDoesNotExistException("User does not exist");
            if(user.isActive())throw new UserDoesNotExistException("you are already logged in");
            if(user.getEmail().equalsIgnoreCase(request.getEmail()))user.setActive(true);
            else throw new UserDoesNotExistException("something went wrong");
            users.save(user);
            LogInResponse logInResponse = new LogInResponse();
            logInResponse.setEmail(user.getEmail());
            logInResponse.setUsername(user.getUsername());
            return logInResponse;
    }
    @Override
    public SignUpResponse signUp(SignUpRequest request) {
             if(users.findUsersByUsername
             (request.getUsername().toLowerCase())!=null)throw new
             UserDoesNotExistException("user  "+request.getUsername()+"  already exists");
             User user = new User();
             if(!EmailValidator.getInstance().isValid(request.getEmail()))
                 throw new UserDoesNotExistException("Invalid email");
             user.setEmail(request.getEmail());
             user.setUsername(request.getUsername().toLowerCase());
             if(!request.getPhoneNumber().matches("^(0|234|\\+234)?[7-9][0-1]\\d{8}$"))throw new UserDoesNotExistException("Invalid phone number");
             user.setPhoneNumber(request.getPhoneNumber());
             user.setResidentialAddress(request.getResidentialAddress());
             addresses.save(user.getResidentialAddress());
             var newUser =users.save(user);
             SignUpResponse response = new SignUpResponse();
             response.setEmail(request.getEmail());
             response.setUsername(request.getUsername());
             response.setResidentialAddress(request.getResidentialAddress());
             response.setId(newUser.getId());
             return response;
    }
    @Override
    public LogInResponse logOut(LoginRequest request) {
        var user =users.findUsersByUsername(request.getUsername());
        if(user == null)throw new UserDoesNotExistException("User does not exist");
        if(!user.isActive())throw new UserDoesNotExistException("you are already logged out");
        if(user.getEmail().equalsIgnoreCase(request.getEmail()))user.setActive(false);
        else throw new UserDoesNotExistException("something went wrong");
        users.save(user);
        LogInResponse logInResponse = new LogInResponse();
        logInResponse.setEmail(user.getEmail());
        logInResponse.setUsername(user.getUsername());
        return logInResponse;
    }
    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        var user = users.findUserById(request.getUserId());
        if(user == null)throw new UserDoesNotExistException("user does not exist");
        if(!user.isActive())throw new UserDoesNotExistException("you are inactive log-in to create order");
        OrderHistory orderHistory = new OrderHistory();
        var myOrder =orderServices.createOrder(request);
        myOrder.setPickUpLocation(user.getResidentialAddress());
        myOrder.setDeliveryAddress(request.getDeliveryAddress());
        addressServices.addAllAddress(List.of(myOrder.getPickUpLocation(),myOrder.getDeliveryAddress()));
        myOrder.setUserId(user.getId());
        orders.save(myOrder);
        user.getOrders().add(myOrder);
        users.save(user);
        orderHistory.setOrderId(myOrder.getId());
        orderHistory.setCurrentOrderStatus(OrderStatus.PLACED);
        orderHistory.setTimeUpdated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        orderHistory.setCurrentLocation(user.getResidentialAddress());
        orderHistory.setRemarks("searching for agents........");
        orderHistoryRepository.save(orderHistory);
        return mapOrderToResponse(myOrder);
    }
    @Override
    public OrderResponse CancelOrder(UUID orderId) {
        var myOrder =orderServices.findOrderById(orderId);
        if(myOrder==null)throw new OrderNotFoundExp("these order has never been placed ");
        var user =users.findUserById(myOrder.getUserId());
        if(!user.isActive())throw new UserDoesNotExistException("you are inactive log-in to cancel order");
        orderServices.cancelOrder(myOrder.getId());
        var toReturn = mapOrderToResponse(myOrder);
        toReturn.setOrderStatus(OrderStatus.DECLINED);
        return toReturn;
    }
    @Override
    public List<OrderHistory> trackOrder(UUID orderId) {
        return orderHistoryRepository.findOrderHistoriesByOrderId(orderId).stream()
                .sorted(Comparator.comparing(OrderHistory::getId))
                .collect(Collectors.toList());
    }
}
