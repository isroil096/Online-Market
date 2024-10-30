package com.smart.parking.repository;

import com.smart.parking.entity.Motorbike;
import com.smart.parking.entity.constants.MotoCity;
import com.smart.parking.entity.constants.MotoColor;
import com.smart.parking.entity.constants.MotoMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Motorbike,Long> {

    List<Motorbike>findByColor(MotoColor color);

    List<Motorbike>findByMake(MotoMake make);

    List<Motorbike>findByCity(MotoCity city);

    List<Motorbike>findByCityAndColor(MotoCity city, MotoColor color);

    List<Motorbike>findByCityAndMake(MotoCity city, MotoMake make);

    List<Motorbike>findByMakeAndColor( MotoMake make, MotoColor color);

    List<Motorbike>findByCityAndColorAndMake(MotoCity city , MotoColor color, MotoMake make);


}
