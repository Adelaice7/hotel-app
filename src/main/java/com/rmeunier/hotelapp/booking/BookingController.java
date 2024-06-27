package com.rmeunier.hotelapp.booking;

import com.rmeunier.hotelapp.booking.model.Booking;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.saveBooking(booking));
    }

    @PutMapping("/{id}")
    public void updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking) {
        // TODO add feedback after update
        bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id) {
        // TODO add feedback after delete
        bookingService.deleteBooking(id);
    }
}
