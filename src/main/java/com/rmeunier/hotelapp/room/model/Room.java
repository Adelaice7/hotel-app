package com.rmeunier.hotelapp.room.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @SequenceGenerator(name = "room_id_seq", sequenceName = "room_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "room_id_seq")
    private Long id;
    private String roomNumber;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private RoomStatus status;

    public Room(String roomNumber, RoomType roomType, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
    }
}
