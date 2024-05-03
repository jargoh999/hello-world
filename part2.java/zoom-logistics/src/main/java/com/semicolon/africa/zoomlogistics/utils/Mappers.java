package com.semicolon.africa.zoomlogistics.utils;

import com.semicolon.africa.zoomlogistics.data.models.Address;
import com.semicolon.africa.zoomlogistics.data.models.Item;
import com.semicolon.africa.zoomlogistics.data.models.Order;
import com.semicolon.africa.zoomlogistics.dto.*;

public class Mappers {

    public static void  mapAddressRequestToAddress(AddressRequest addressRequest, Address address){
        address.setStreet(addressRequest.getStreet());
        address.setCityName(addressRequest.getCityName());
        address.setState(addressRequest.getState());
        address.setCountryName(addressRequest.getCountryName());
        address.setHouseNumber(addressRequest.getHouseNumber());
    }

    public static void  mapItemRequestToItem(ItemRequest itemRequest, Item item){
         item.setItemName(itemRequest.getItemName());
         item.setDescription(itemRequest.getDescription());
    }
    public static ItemResponse  mapItemRequestToResponse(ItemRequest itemRequest){
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setItemName(itemRequest.getItemName());
        itemResponse.setDescription(itemRequest.getDescription());
        itemResponse.setId(itemRequest.getId());
        return itemResponse;
    }

    public static AddressResponse  mapAddressRequestToResponse(AddressRequest addressRequest){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setCityName(addressRequest.getCityName());
        addressResponse.setCountryName(addressRequest.getCountryName());
        addressResponse.setHouseNumber(addressRequest.getHouseNumber());
        addressResponse.setState(addressRequest.getState());
        addressResponse.setStreet(addressRequest.getStreet());
        addressResponse.setId(addressRequest.getId());
        return addressResponse;
    }

    public  static void mapOrderRequestToOrder(OrderRequest orderRequest, Order order){
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setItems(orderRequest.getItems());
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setTimeAssigned(orderRequest.getTimeAccepted());
        order.setTimeDelivered(orderRequest.getTimeDelivered());
        order.setUserId(orderRequest.getUserId());
        order.setTimeRejected(orderRequest.getTimeCancelled());
        order.setTimePlaced(orderRequest.getTimePlaced());
    }


    public static OrderResponse mapOrderToResponse(Order order){
         OrderResponse orderResponse = new OrderResponse();
         orderResponse.setOrderStatus(order.getOrderStatus());
         orderResponse.setUserId(order.getUserId());
         orderResponse.setTimePlaced(order.getTimePlaced());
         orderResponse.setDeliveryAddress(order.getDeliveryAddress());
         orderResponse.setPickUpLocation(order.getPickUpLocation());
         orderResponse.setItems(order.getItems());
         orderResponse.setId(order.getId());
         return orderResponse;
    }

}
