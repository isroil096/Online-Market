package com.smart.parking.repository;

import com.smart.parking.entity.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Long> {


}
