package com.smart.parking.repository;

import com.smart.parking.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM parking_place WHERE user_id =:user_id AND parking_name =:parking_name AND is_deleted =:is_deleted")
    Optional<Parking> findByUserIdAndParkingName(@Param("user_id") Long userId, @Param("parking_name") String parking_name, @Param("is_deleted") Boolean isDeleted);

    @Query(nativeQuery = true, value = "SELECT * FROM parking_place WHERE user_id =:user_id AND is_deleted =:is_deleted")
    List<Parking> findParkingByUserId(@Param("user_id") Long userId, @Param("is_deleted") Boolean isDeleted);

    @Query(nativeQuery = true, value = "SELECT * FROM parking_place WHERE id =:id AND is_deleted =:is_deleted")
    Optional<Parking> findByParkingId(@Param("id") Long id, @Param("is_deleted") Boolean isDeleted);
}
