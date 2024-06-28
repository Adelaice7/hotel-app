package com.rmeunier.hotelapp.room.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "room_inventory")
public class RoomInventory {
    @Id
    @SequenceGenerator(name = "room_inventory_id_seq", sequenceName = "room_inventory_id")
    @GeneratedValue(generator = "room_inventory_id_seq")
    private Long id;
    @Enumerated(EnumType.STRING)
    @NonNull
    private RoomType roomType;
    private LocalDate date;
    private int totalInventory;
    private int reservedInventory;

    public RoomInventory(RoomType roomType, LocalDate date, int totalInventory, int reservedInventory) {
        this.roomType = roomType;
        this.date = date;
        this.totalInventory = totalInventory;
        this.reservedInventory = reservedInventory;
    }
}
