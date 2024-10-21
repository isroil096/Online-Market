package com.smart.parking.repository;

import com.smart.parking.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Long> {

    @Query("select u from Card u where u.number=:number")
    Optional<Card> findByNumber(@Param("number") String number);

    void deleteByUserId(Long id);


}
