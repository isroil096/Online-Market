package com.smart.parking.service.parking;

import com.smart.parking.dto.car.CarGetRequest;
import com.smart.parking.dto.car.CarParkingGetRequest;
import com.smart.parking.dto.car.CarParkingPostRequest;
import com.smart.parking.dto.parking.ParkingCarGetRequest;
import com.smart.parking.dto.parking.ParkingGetRequest;
import com.smart.parking.dto.parking.ParkingPostRequest;
import com.smart.parking.entity.Car;
import com.smart.parking.entity.Parking;
import com.smart.parking.entity.User;
import com.smart.parking.exception.NotFoundException;
import com.smart.parking.repository.CarRepository;
import com.smart.parking.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private final CarRepository carRepository;
    private final ParkingRepository parkingRepository;

    @Override
    public void save(ParkingPostRequest request, User user) {
        Optional<Parking> parkingEntity = parkingRepository.findByUserIdAndParkingName(user.getId(), request.getParkingName(), false);
        Set<Car> cars = new HashSet<>();

        // IF PARKING EXITS
        if (parkingEntity.isPresent()) {
            for (CarParkingPostRequest car : request.getCars()) {
                Car carEntity = Car.builder()
                        .carName(car.getCarName())
                        .numberPlate(car.getNumberPlate())
                        .user(user)
                        .isDeleted(false)
                        .parkingPlaces(new HashSet<>(Collections.singleton(parkingEntity.get())))
                        .build();
                cars.add(carRepository.save(carEntity));
            }
            Parking parkingPlace = parkingEntity.get();
            parkingPlace.setParkedCars(cars);
            parkingRepository.save(parkingPlace);
        } else {
            throw new NotFoundException("PARKING WITH NAME NOT FOUND");
        }
    }

    public List<ParkingGetRequest> getParkingById(Long userId) {
        List<Parking> parkingList = parkingRepository.findParkingByUserId(userId, false);
        List<ParkingGetRequest> parkingGetRequests = new ArrayList<>();
        for (Parking parking : parkingList) {
            Set<ParkingCarGetRequest> listCarResponse = new HashSet<>();
            for (Car car : parking.getParkedCars()) {
                ParkingCarGetRequest carResponse = ParkingCarGetRequest.builder()
                        .id(car.getId())
                        .carName(car.getCarName())
                        .numberPlate(car.getNumberPlate())
                        .build();
                listCarResponse.add(carResponse);
            }
            ParkingGetRequest listParkingResponse = ParkingGetRequest.builder()
                    .id(parking.getId())
                    .parkingName(parking.getParkingName())
                    .cars(listCarResponse)
                    .build();
            parkingGetRequests.add(listParkingResponse);
        }
        return parkingGetRequests;
    }

    public ParkingGetRequest getByParkingId(Long parkingId) {
        Optional<Parking> parkingEntity = parkingRepository.findByParkingId(parkingId, false);
        if (parkingEntity.isPresent()) {
            Set<ParkingCarGetRequest> listCarResponse = new HashSet<>();
            for (Car car : parkingEntity.get().getParkedCars()) {
                ParkingCarGetRequest carResponse = ParkingCarGetRequest.builder()
                        .id(car.getId())
                        .carName(car.getCarName())
                        .numberPlate(car.getNumberPlate())
                        .build();
                listCarResponse.add(carResponse);
            }
            return ParkingGetRequest.builder()
                    .id(parkingEntity.get().getId())
                    .parkingName(parkingEntity.get().getParkingName())
                    .cars(listCarResponse)
                    .build();
        } else {
            throw new NotFoundException("PARKING WITH ID NOT FOUND");
        }
    }

    public void deleteParkingById(Long parkingId) {
        Optional<Parking> parkingEntity = parkingRepository.findByParkingId(parkingId, false);
        if (parkingEntity.isPresent()) {
            Parking parking = parkingEntity.get();
            parking.setIsDeleted(true);
            parkingRepository.save(parking);
        } else {
            throw new NotFoundException("PARKING WITH ID NOT FOUND");
        }
    }

    public void update(Long parkingId) {
        Optional<Parking> parkingEntity = parkingRepository.findByParkingId(parkingId, false);
        if (parkingEntity.isPresent()) {
            Parking parking = parkingEntity.get();

        }
    }
}
