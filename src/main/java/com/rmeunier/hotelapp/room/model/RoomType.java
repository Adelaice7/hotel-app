package com.rmeunier.hotelapp.room.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "room_type")
public class RoomType {
    @Id
    @SequenceGenerator(name = "room_type_id_seq", sequenceName = "room_type_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "room_type_id_seq")
    private Long id;
    private String name;
    private String description;
    private int capacity;
    private double basePrice;
    private boolean isSmoking;
    private boolean isWifi;
    private boolean isParking;
}
