package com.smart.parking.service;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.dto.CarRequestDto;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.User;
import com.smart.parking.exception.BadRequest;
import com.smart.parking.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Component
@RequiredArgsConstructor

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public void addCard(CarRequestDto cardRequest, User user) {
        Car car = dtoCard(cardRequest);
        car.setPhone(cardRequest.getPhone());
        car.setPrice(cardRequest.getPrice());
        car.setYear(cardRequest.getYear());
        car.setName(cardRequest.getName());
        car.setType(cardRequest.getType());
        car.setModel(cardRequest.getModel());
        car.setColor(cardRequest.getColor());
        car.setUser(user);
        carRepository.save(car);
    }


    @Override
    public void updateCard(Long id, CarRequestDto cardRequest) {
        Car car = carRepository.findById(id).orElseThrow();
        car.setPrice(cardRequest.getPrice());
        car.setYear(cardRequest.getYear());
        car.setName(cardRequest.getName());
        car.setType(cardRequest.getType());
        car.setModel(cardRequest.getModel());
        car.setColor(cardRequest.getColor());
        car.setPhone(cardRequest.getPhone());
        carRepository.save(car);
    }


    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }



    @Override
    public void deleteCard(Long id) {
        Optional<Car> byId = carRepository.findById(id);
        if (byId.isEmpty()){
            throw new BadRequest("card Not Found");
        }else {
            carRepository.delete(byId.get());
        }

    }

    @Override
    public Optional<Car> findByPhone(String phone) {
        return carRepository.findByPhone(phone);
    }

    @Override
    public CarRequest car(Car car) {
        return CarRequest.builder()
                .id(car.getId())
                .name(car.getName())
                .year(car.getYear())
                .type(car.getType())
                .color(car.getColor())
                .model(car.getModel())
                .price(car.getPrice()).build();
    }

    @Override
    public Optional<List<Car>> findByUserId(Long id) {
        return carRepository.findByUserId(id);
    }


    public Car dtoCard(CarRequestDto cardRequest) {
        Car car = new Car();
        car.setPrice(cardRequest.getPrice());
        car.setYear(cardRequest.getYear());
        car.setName(cardRequest.getName());
        car.setType(cardRequest.getType());
        car.setModel(cardRequest.getModel());
        car.setColor(cardRequest.getColor());
        car.setPhone(cardRequest.getPhone());
        return car;
    }
}
