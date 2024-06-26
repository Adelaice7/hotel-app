package com.rmeunier.hotelapp.room.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @SequenceGenerator(name = "room_id_seq", sequenceName = "room_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "room_id_seq")
    private Long id;
    private String roomNumber;
    private RoomType roomType;
    private RoomStatus status;

    public Room(String roomNumber, RoomType roomType, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
    }
}
