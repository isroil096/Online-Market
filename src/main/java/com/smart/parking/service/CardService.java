package com.smart.parking.service;

import com.smart.parking.dto.CardRequest;
import com.smart.parking.entity.Card;
import com.smart.parking.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CardService {

    void addCard(CardRequest cardRequest, User user);
    void updateCard(Long id , CardRequest cardRequest);
    List<Card> findAll ();
    void deleteCard(Long id);
}
