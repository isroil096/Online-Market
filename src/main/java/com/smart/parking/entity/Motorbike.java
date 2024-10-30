package com.smart.parking.entity;

import com.smart.parking.entity.constants.MotoCity;
import com.smart.parking.entity.constants.MotoColor;
import com.smart.parking.entity.constants.MotoMake;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "moto")
public class Motorbike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MotoMake make;
    private String name;
    private MotoColor color;
    private MotoCity city;
    private Long year;


}
