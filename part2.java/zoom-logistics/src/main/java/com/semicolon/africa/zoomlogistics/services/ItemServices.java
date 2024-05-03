package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.Item;
import com.semicolon.africa.zoomlogistics.dto.ItemRequest;
import com.semicolon.africa.zoomlogistics.dto.ItemResponse;

import java.util.List;

public interface ItemServices {
    Item findItemById(Long id);
    Item findItemByItemName(String name);
    Item findItemByDescription(String description);
    ItemResponse addItem(ItemRequest itemRequest);
    ItemResponse updateItem(Long id,ItemRequest itemRequest);
    String deleteItem(Long id);

    void addAllItem(List<Item> items);
}