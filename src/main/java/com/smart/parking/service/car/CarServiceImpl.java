package com.smart.parking.service.car;

import com.smart.parking.dto.CarRequest;
import com.smart.parking.dto.ParkingRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.ParkingPlace;
import com.smart.parking.entity.User;
import com.smart.parking.exception.NotFoundException;
import com.smart.parking.repository.CarRepository;
import com.smart.parking.repository.ParkingPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;
    private final ParkingPlaceRepository parkingPlaceRepository;

    @Override
    public void save(CarRequest request, User user) {
        var car = Car.builder()
                .id(request.getId())
                .carName(request.getCarName())
                .numberPlate(request.getNumberPlate())
                .user(user)
                .build();
        repository.save(car);
    }

    @Override
    public CarRequest findByNumberPlate(String numberPlate) {
        Optional<Car> car = repository.findByLicense(numberPlate);
        if (car.isPresent()) {
            return CarRequest.builder()
                    .id(car.get().getId())
                    .carName(car.get().getCarName())
                    .numberPlate(car.get().getNumberPlate())
                    .build();
        } else {
            throw new NotFoundException("Car not found");
        }
    }

    @Override
    public void update(Long user_id, CarRequest request) {
        Optional<Car> car = repository.findByUserId(user_id);
        if (car.isPresent()) {
            Car carEntity = car.get();
            carEntity.setCarName(request.getCarName());
            carEntity.setNumberPlate(request.getNumberPlate());
            repository.save(carEntity);
        } else {
            throw new NotFoundException("Car not found");
        }
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public void saveCar(CarRequest carRequest, User user) {
        Car car = new Car();
        car.setCarName(carRequest.getCarName());
        car.setNumberPlate(carRequest.getNumberPlate());
        car.setUser(user);

        Set<ParkingPlace> parkingPlaces = new HashSet<>();
        Set<Car> cars = new HashSet<>();
        ParkingPlace parkingPlace = new ParkingPlace();
        for(ParkingRequest parkingEntity: carRequest.getParking()) {
            parkingPlace.setParkingName(parkingEntity.getParkingName());
            parkingPlace.setUser(user);
            cars.add(car);
            parkingPlace.setParkedCars(cars);
            parkingPlaces.add(parkingPlace);
            parkingPlaceRepository.save(parkingPlace);
        }

        car.setParkingPlaces(parkingPlaces);
        repository.save(car);
    }
}
