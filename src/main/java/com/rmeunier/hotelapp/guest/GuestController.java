package com.rmeunier.hotelapp.guest;

import com.rmeunier.hotelapp.guest.model.Guest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") Long id) {
        return guestService.getGuest(id);
    }

    @PostMapping()
    public Guest saveNewGuest(@RequestBody Guest guest) {
        return guestService.saveGuest(guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable("id") Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.ok().build();
    }
}
