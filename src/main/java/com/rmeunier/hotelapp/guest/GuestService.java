package com.rmeunier.hotelapp.guest;

import com.rmeunier.hotelapp.guest.model.Guest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuest(Long id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Guest not found with id: " + id));
    }

    public Guest saveGuest(Guest guest) {
        // Do some validation
        guestRepository.findByEmail(guest.getEmail())
                .ifPresent(guestInDb -> {
                    throw new IllegalArgumentException(
                            "Guest with email: " + guest.getEmail() + " already exists.");
                });

        // TODO save address separetely

        return guestRepository.save(guest);
    }

    @Transactional
    public void updateGuest(Long id, String firstName, String lastName,
                            String email, String phone, LocalDate dateOfBirth) {
        Guest guestInDb = guestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Guest not found with id: " + id));

        if (firstName != null && !Objects.equals(guestInDb.getFirstName(), firstName)) {
            guestInDb.setFirstName(firstName);
        }

        if (lastName != null && !Objects.equals(guestInDb.getLastName(), lastName)) {
            guestInDb.setLastName(lastName);
        }

        if (email != null && !Objects.equals(guestInDb.getEmail(), email)) {
            guestInDb.setEmail(email);
        }

        if (phone != null && !Objects.equals(guestInDb.getPhone(), phone)) {
            guestInDb.setPhone(phone);
        }

        if (dateOfBirth != null && !Objects.equals(guestInDb.getDateOfBirth(), dateOfBirth)) {
            guestInDb.setDateOfBirth(dateOfBirth);
        }

        // TODO add pw enc
    }

    public void deleteGuest(Long id) {
        boolean exists = guestRepository.existsById(id);
        if (exists) {
            guestRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Guest not found with id: " + id);
        }
    }
}
