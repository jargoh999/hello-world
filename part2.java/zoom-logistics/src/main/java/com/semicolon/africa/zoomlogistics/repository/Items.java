package com.semicolon.africa.zoomlogistics.repository;

import com.semicolon.africa.zoomlogistics.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Items extends JpaRepository<Item,Long> {
    Item findItemById(Long id);
    Item findItemByItemName(String name);
    Item findItemByDescription(String description);
}

