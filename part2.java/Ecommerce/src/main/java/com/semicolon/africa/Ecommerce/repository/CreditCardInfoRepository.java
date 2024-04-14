package com.semicolon.africa.Ecommerce.repository;

import com.semicolon.africa.Ecommerce.data.models.CardType;
import com.semicolon.africa.Ecommerce.data.models.CreditCardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardInfoRepository extends JpaRepository<CreditCardInfo,Long> {
     CreditCardInfo findCreditCardInfoByCard(CardType cardType);
     CreditCardInfo findCreditCardInfoByCardCvv(String cvv);
     CreditCardInfo findCreditCardInfoByNameOnCard(String nameOnCard);
}
