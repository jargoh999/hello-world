package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.Item;
import com.semicolon.africa.zoomlogistics.dto.ItemRequest;
import com.semicolon.africa.zoomlogistics.dto.ItemResponse;
import com.semicolon.africa.zoomlogistics.exceptions.ItemNotfoundExp;
import com.semicolon.africa.zoomlogistics.repository.Items;
import com.semicolon.africa.zoomlogistics.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.semicolon.africa.zoomlogistics.utils.Mappers.mapItemRequestToItem;
import static com.semicolon.africa.zoomlogistics.utils.Mappers.mapItemRequestToResponse;

@Service
public class ItemServicesImpl implements ItemServices {
    @Autowired
    private Items items;
    @Override
    public Item findItemById(Long id) {
        return items.findItemById(id);
    }

    @Override
    public Item findItemByItemName(String name) {
        return items.findItemByItemName(name);
    }

    @Override
    public Item findItemByDescription(String description) {
        return items.findItemByDescription(description);
    }

    @Override
    public ItemResponse addItem(ItemRequest itemRequest) {
        Item item = new Item();
        mapItemRequestToItem(itemRequest,item);
        var newItem = items.save(item);
        itemRequest.setId(newItem.getId());
        return mapItemRequestToResponse(itemRequest);
    }

    @Override
    public ItemResponse updateItem(Long id, ItemRequest itemRequest) {
        var item =items.findItemById(id);
        if(item== null)throw new ItemNotfoundExp("Item not found");
        mapItemRequestToItem(itemRequest, item);
        var newItem = items.save(item);
        itemRequest.setId(newItem.getId());
        return mapItemRequestToResponse(itemRequest);
    }

    @Override
    public String deleteItem(Long id) {
        if(findItemById(id) == null)throw new ItemNotfoundExp("Item not found");
        items.delete(items.findItemById(id));
        return "item successfully deleted";
    }

    @Override
    public void addAllItem(List<Item> newItems) {
        items.saveAll(newItems);
    }
}
