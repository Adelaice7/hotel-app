package com.rmeunier.hotelapp.booking;

import com.rmeunier.hotelapp.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with id: " + id));
    }

    public List<Booking> getBookingsByRoomId(Long roomId) {
        return bookingRepository.findBookingsByRoomId(roomId);
    }

    public List<Booking> getBookingsByGuestId(Long guestId) {
        return bookingRepository.findBookingsByGuestId(guestId);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void updateBooking(Long id, Booking booking) {
        if (!bookingRepository.existsById(id)) {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        }

        bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        }
    }

}
