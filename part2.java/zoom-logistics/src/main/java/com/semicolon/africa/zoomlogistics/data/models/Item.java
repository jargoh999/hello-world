package com.semicolon.africa.zoomlogistics.data.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "logistic-item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String itemName;
}
