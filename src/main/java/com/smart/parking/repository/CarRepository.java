package com.smart.parking.repository;

import com.smart.parking.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM car WHERE number_plate =:licence AND is_deleted =:is_deleted")
    Optional<Car> findByLicense(@Param("licence") String license, @Param("is_deleted") Boolean isDeleted);

    @Query(nativeQuery = true, value = "SELECT * FROM car WHERE user_id =:user_id AND is_deleted =:is_deleted")
    List<Car>findByUserId(@Param("user_id") Long userId, @Param("is_deleted") Boolean isDeleted);

    @Query(nativeQuery = true, value = "SELECT * FROM car WHERE is_deleted =:is_deleted")
    List<Car> findAll(@Param("is_deleted") Boolean isDeleted);

    @Query(nativeQuery = true, value = "SELECT * FROM car WHERE id =:id AND is_deleted =:is_deleted")
    Optional<Car> findCarById(@Param("id") Long id, @Param("is_deleted") Boolean isDeleted);
}
