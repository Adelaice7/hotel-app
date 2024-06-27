package com.rmeunier.hotelapp.guest;

import com.rmeunier.hotelapp.guest.model.Guest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/guests"))
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
    public ResponseEntity<Guest> getGuest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(guestService.getGuest(id));
    }

    @PostMapping
    public ResponseEntity<Guest> saveNewGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok(guestService.saveGuest(guest));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void updateGuest(@PathVariable("id") Long id,
                            @RequestParam(value = "firstName", required = false) String firstName,
                            @RequestParam(value = "lastName", required = false) String lastName,
                            @RequestParam(value = "email", required = false) String email,
                            @RequestParam(value = "phone", required = false) String phone,
                            @RequestParam(value = "dateOfBirth", required = false) LocalDate dateOfBirth){
        // TODO add password + validation in service
        guestService.updateGuest(id, firstName, lastName, email, phone, dateOfBirth);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable("id") Long id) {
        // TODO add feedback after deleting
        guestService.deleteGuest(id);
        return ResponseEntity.ok().build();
    }
}
