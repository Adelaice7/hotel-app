package com.rmeunier.hotelapp.billing;

import com.rmeunier.hotelapp.booking.model.Booking;
import com.rmeunier.hotelapp.guest.model.Guest;
import com.rmeunier.hotelapp.room.model.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @ManyToMany
    @JoinTable(name = "bills_guest")
    private List<Guest> guest;
    @ManyToMany
    @JoinTable(name = "bills_booking")
    private List<Booking> booking;
    private double total;

    public Bill(Room room, List<Guest> guest, List<Booking> booking, double total) {
        this.room = room;
        this.guest = guest;
        this.booking = booking;
        this.total = total;
    }
}
