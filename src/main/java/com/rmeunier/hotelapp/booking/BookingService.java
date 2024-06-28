package com.rmeunier.hotelapp.booking;

import com.rmeunier.hotelapp.booking.model.Booking;
import com.rmeunier.hotelapp.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final RoomService roomService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomService roomService) {
        this.bookingRepository = bookingRepository;
        this.roomService = roomService;
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

    public Booking createBooking(Booking booking) {
        // TODO do validation on room availability, fix booking status
        roomService.bookRoomByRoomNumber(booking.getRoom().getRoomNumber());
        return bookingRepository.save(booking);
    }

    public void updateBooking(Long id, Booking booking) {
        if (!bookingRepository.existsById(id)) {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        }

        bookingRepository.save(booking);
    }

    public void cancelBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Booking not found with id: " + id);
        }
    }

}
