package com.smart.parking.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smart.parking.entity.constants.CarCity;
import com.smart.parking.entity.constants.CarColor;
import com.smart.parking.entity.constants.CarName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private Long price;
    private String model;
    private CarName name;
    private CarColor color;
    private CarCity city;
    private String type;
    private Long year;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
