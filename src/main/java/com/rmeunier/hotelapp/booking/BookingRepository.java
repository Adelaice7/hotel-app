package com.rmeunier.hotelapp.booking;

import com.rmeunier.hotelapp.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingsByRoomId(Long roomId);

    List<Booking> findBookingsByGuestId(Long guestId);
}
