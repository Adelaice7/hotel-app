package com.rmeunier.hotelapp.room.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_status")
public enum RoomStatus {
    FREE,
    OCCUPIED,
    BOOKED,
    CANCELED,
    RESERVED,
    MAINTENANCE
}
