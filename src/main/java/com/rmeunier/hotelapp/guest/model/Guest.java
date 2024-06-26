package com.rmeunier.hotelapp.guest.model;

import com.rmeunier.hotelapp.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "guest")
public class Guest extends User {
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "home_address_id")
    private HomeAddress homeAddress;
    private String phone;
    private LocalDate dateOfBirth;
    @Transient
    private int age;

    public Guest(@NonNull String email, @NonNull String password,
                 String firstName, String lastName,
                 HomeAddress homeAddress, String phone, LocalDate dateOfBirth) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    private void setAge() {
        this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

}
