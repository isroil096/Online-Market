package com.smart.parking.repository;

import com.smart.parking.entity.Seller;
import com.smart.parking.entity.constants.CarCity;
import com.smart.parking.entity.constants.CarColor;
import com.smart.parking.entity.constants.CarName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller,Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM seller WHERE user_id =:user_id")
    Optional<List<Seller>> findByUserId(@Param("user_id") Long id);


    List<Seller> findByName(CarName name);

    List<Seller>findByColor(CarColor color);

    List<Seller>findByCity(CarCity city);

    List<Seller>findByCityAndColor(CarCity city, CarColor color);

    List<Seller>findByCityAndName(CarCity city, CarName name);

    List<Seller>findByColorAndName(CarColor color, CarName name);

    List<Seller>findByCityAndColorAndName(CarCity city, CarColor color, CarName name);

    void deleteByUserId(Long id);


}
