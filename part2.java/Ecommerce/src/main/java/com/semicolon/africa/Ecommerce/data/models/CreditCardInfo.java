package com.semicolon.africa.Ecommerce.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class CreditCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardCvv;
    private String expirationDate;
    private String cardNumber;
    private String nameOnCard;
    private CardType card;
}