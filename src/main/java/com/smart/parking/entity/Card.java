package com.smart.parking.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private Long number;
    private String type;
    private Long code;

    @ManyToOne()
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;

}
