package com.smart.parking.service;

import com.smart.parking.dto.SellerRequest;
import com.smart.parking.dto.SellerRequestDto;
import com.smart.parking.entity.Seller;
import com.smart.parking.entity.User;
import com.smart.parking.entity.constants.CarCity;
import com.smart.parking.entity.constants.CarColor;
import com.smart.parking.entity.constants.CarName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SellerService {

    void addCar(SellerRequestDto sellerRequestDto, User user);

    void updateCar(Long id , SellerRequestDto sellerRequestDto);

    List<Seller> findAll ();

    void deleteCar(Long id);

    SellerRequest seller(Seller seller);

    Optional<List<Seller>> findByUserId(Long id);

    List<Seller> findByName(CarName name);

    List<Seller> findByColor(CarColor color);

    List<Seller> findByCity(CarCity city);

    List<Seller> findByCityAndColor(CarCity city, CarColor color);

    List<Seller> findByCityAndName(CarCity city, CarName name);

    List<Seller> findByColorAndName(CarColor color, CarName name);

    List<Seller> findByCityAndNameAndColor(CarCity city, CarName name, CarColor color);




}
