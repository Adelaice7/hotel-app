package com.rmeunier.hotelapp.billing;

import com.rmeunier.hotelapp.booking.BookingService;
import com.rmeunier.hotelapp.booking.model.Booking;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {
    private BookingService bookingService;

    @Autowired
    public PricingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Bill generateBill(@NonNull final  String bookingId) {
        final Booking booking = bookingService.getBookingById(Long.parseLong(bookingId));
        final Bill bill = new Bill();
        bill.setRoom(booking.getRoom());
        // TODO fix, add guest
        bill.setBooking(List.of(booking));
        bill.setTotal(booking.getTotalPrice());
        return bill;
    }
}
