package com.smart.parking.service;

import com.smart.parking.dto.CardRequest;
import com.smart.parking.entity.Card;
import com.smart.parking.entity.User;
import com.smart.parking.exception.BadRequest;
import com.smart.parking.repository.CardRepository;
import com.smart.parking.repository.TokenRepository;
import com.smart.parking.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Component
@RequiredArgsConstructor

public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    @Override
    public void addCard(CardRequest cardRequest,User user) {
        Card card = dtoCard(cardRequest);
        card.setNumber(cardRequest.getNumber());
        card.setCode(cardRequest.getCode());
        card.setType(cardRequest.getType());
        card.setUser(user);
        cardRepository.save(card);
    }


    @Override
    public void updateCard(Long id, CardRequest cardRequest) {
        Card card = cardRepository.findById(id).orElseThrow();
        card.setCode(cardRequest.getCode());
        card.setType(cardRequest.getType());
        card.setNumber(cardRequest.getNumber());
        cardRepository.save(card);
    }


    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }



    @Override
    public void deleteCard(Long id) {
        Optional<Card> byId = cardRepository.findById(id);
        if (byId.isEmpty()){
            throw new BadRequest("card Not Found");
        }else {
            cardRepository.delete(byId.get());
        }

    }


    public Card dtoCard(CardRequest cardRequest) {
        Card card = new Card();
        card.setCode(cardRequest.getCode());
        card.setType(cardRequest.getType());
        card.setNumber(card.getNumber());
        return card;
    }
}
