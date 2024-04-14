package com.semicolon.africa.Ecommerce.services;
import com.semicolon.africa.Ecommerce.data.models.*;
import com.semicolon.africa.Ecommerce.dto.BuyerRegisterRequest;
import com.semicolon.africa.Ecommerce.dto.RegisterRequest;
import com.semicolon.africa.Ecommerce.dto.RegisterResponse;
import com.semicolon.africa.Ecommerce.exceptions.InvalidCardException;
import com.semicolon.africa.Ecommerce.exceptions.InvalidRoleException;
import com.semicolon.africa.Ecommerce.exceptions.UserAlreadyExistException;
import com.semicolon.africa.Ecommerce.repository.AddressRepository;
import com.semicolon.africa.Ecommerce.repository.BillingInformationRepository;
import com.semicolon.africa.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.semicolon.africa.Ecommerce.data.models.Role.BUYER;
import static com.semicolon.africa.Ecommerce.data.models.Role.SELLER;
import static com.semicolon.africa.Ecommerce.mappers.Mappers.*;


@Service
public class UserServicesImpl implements UserServices{
   @Autowired
   private UserRepository users;
   @Autowired
   private BillingInformationRepository billingInformationRepository;
   @Autowired
   private AddressRepository addressRepository;

    @Override
    public RegisterResponse SignUp(RegisterRequest registerRequest) {
        if(Role.valueOf(registerRequest.getRole())!=SELLER)throw new InvalidRoleException("sign up as a Buyer that you are");
        if(users.findUserByUserName(registerRequest.getUserName())!=null)throw new UserAlreadyExistException("user already exist");
        Seller seller = new Seller();
        mapRequestToSeller(registerRequest,seller);
        users.save(seller);
        return mapRegisterRequestToResponse(registerRequest);
    }
    @Override
    public RegisterResponse SignUp(BuyerRegisterRequest buyerRegisterRequest) {
        if(Role.valueOf(buyerRegisterRequest.getRole())!=BUYER)throw new InvalidRoleException("sign up as a seller that you are");
        if(users.findUserByUserName(buyerRegisterRequest.getUserName())!=null)throw new UserAlreadyExistException("user already exist");
        Buyer buyer = new Buyer();
        mapRequestToBuyer(buyerRegisterRequest,buyer);
        if(!isValid(buyer.getBillingInformation().getCardInfo()))throw new InvalidCardException("your card is not valid");
        users.save(buyer);
        billingInformationRepository.save(buyerRegisterRequest.getBillingInformation());
        addressRepository.save(buyer.getAddress());
        return mapRegisterRequestToResponse(buyerRegisterRequest);
    }
    private boolean isValid(CreditCardInfo creditCardInfo){
                 List<String> validCardNumbers = new ArrayList<>();
                 Collections.addAll(validCardNumbers, "4", "5", "6", "73");
       if(!creditCardInfo.getCardNumber().isEmpty()&&creditCardInfo.getCardNumber().length()<=16) {
           return validCardNumbers.contains(String.valueOf(creditCardInfo.getCardNumber().charAt(creditCardInfo.getCardNumber().length() - 1)));
       }
       return false;
    }








//           if (CredLength > 0 && CredLength == 13 ||
//                CredLength > 0 && CredLength == 16) {
//
//            long[] cardNo = new long[(int) CredLength];
//
//            for (int i = 0; i < CredLength; i++) {
//
//                cardNo[i] = CreditNo % 10l;
//                CreditNo /= 10l;
//            }
//
//            System.out.println("*************************************************");
//
//
//            if (cardNo[CredLength - 1] == 4)
//                System.out.println("** Credit Card Type : VisaCard");
//            if (cardNo[CredLength - 1] == 5)
//                System.out.println("** Credit Card Type : MasterCard");
//            if (cardNo[CredLength - 1] == 6)
//                System.out.println("** Credit Card Type : DiscoverCard");
//            if (cardNo[CredLength - 1] == 3 && cardNo[CredLength - 2] == 7)
//                System.out.println("** Credit Card Type : American Express Cards");
//
//            System.out.printf("** Credit card Number: ");
    }




