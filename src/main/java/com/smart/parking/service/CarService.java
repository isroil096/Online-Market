package com.smart.parking.service;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.dto.CarRequestDto;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {

    void addCard(CarRequestDto cardRequest, User user);

    void updateCard(Long id , CarRequestDto cardRequest);

    List<Car> findAll ();

    void deleteCard(Long id);

    Optional<Car> findByPhone(String phone);

    CarRequest car(Car car);

    Optional<List<Car>> findByUserId(Long id);
}
