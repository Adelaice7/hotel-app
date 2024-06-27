package com.rmeunier.hotelapp.billing;

import com.rmeunier.hotelapp.booking.model.Booking;
import com.rmeunier.hotelapp.guest.model.Guest;
import com.rmeunier.hotelapp.room.model.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @SequenceGenerator(name = "bills_seq", sequenceName = "bills_seq", allocationSize = 1)
    @GeneratedValue(generator = "bills_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
    @OneToMany
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;
    @ManyToMany
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
    private double total;

    public Bill(Room room, Guest guest, Booking booking, double total) {
        this.room = room;
        this.guest = guest;
        this.booking = booking;
        this.total = total;
    }
}
