package com.semicolon.africa.zoomlogistics.services;
import com.semicolon.africa.zoomlogistics.data.models.OrderHistory;
import com.semicolon.africa.zoomlogistics.data.models.User;
import com.semicolon.africa.zoomlogistics.dto.*;

import java.util.List;
import java.util.UUID;

public interface UserServices {
    User findUsersById(Long id);
    LogInResponse logIn(LoginRequest request);
    SignUpResponse signUp(SignUpRequest request);
    LogInResponse logOut(LoginRequest request);
    OrderResponse  placeOrder(OrderRequest request);
    OrderResponse CancelOrder(UUID orderId);
    List<OrderHistory> trackOrder(UUID orderId);
}
