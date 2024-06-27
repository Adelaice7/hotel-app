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
    private String floorNumber;
    private String description;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    @Column(name = "room_status", nullable = false)
    private RoomStatus status;

    public Room(String roomNumber, String floorNumber, String description, RoomType roomType, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.description = description;
        this.roomType = roomType;
        this.status = status;
    }

    public boolean isAvailable() {
        return this.status == RoomStatus.FREE;
    }
}
