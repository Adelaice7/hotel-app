package com.rmeunier.hotelapp.booking;

import com.rmeunier.hotelapp.booking.model.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/room/{roomId}")
    public List<Booking> getBookingsByRoomId(@PathVariable("roomId") Long roomId) {
        return bookingService.getBookingsByRoomId(roomId);
    }

    @GetMapping("/guest/{guestId}")
    public List<Booking> getBookingsByGuestId(@PathVariable("guestId") Long guestId) {
        return bookingService.getBookingsByGuestId(guestId);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/{id}")
    public void updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking) {
        bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
    }
}
