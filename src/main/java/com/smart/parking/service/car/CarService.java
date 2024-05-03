package com.smart.parking.service.car;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.User;

import java.util.List;

public interface CarService {

    void save(CarRequest request, User user);

    CarRequest findByNumberPlate(String numberPlate);

    void update(User user, CarRequest request);

    List<Car> findAll();

    void saveCar(CarRequest carRequest, User user);

    void delete(String numberPlate);

    List<CarRequest> userCars(Long userId);

}
