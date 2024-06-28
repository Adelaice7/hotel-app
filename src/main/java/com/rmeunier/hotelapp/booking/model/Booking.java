package com.rmeunier.hotelapp.booking.model;

import com.rmeunier.hotelapp.guest.model.Guest;
import com.rmeunier.hotelapp.room.model.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @SequenceGenerator(name = "booking_id_seq", sequenceName = "booking_id_", allocationSize = 1)
    @GeneratedValue(generator = "booking_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    @Transient
    private double totalPrice;

    public Booking(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        int numOfNights = Period.between(checkInDate, checkInDate).getDays();
        int price = 2;
        // TODO fix price
        return numOfNights * price;
    }

    public Booking createBooking(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        if (room == null || guest == null || checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Room, guest, check-in date and check-out date must not be null");
        }
        return new Booking(room, guest, checkInDate, checkOutDate);
    }
}
