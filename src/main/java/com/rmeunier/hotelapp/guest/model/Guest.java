package com.rmeunier.hotelapp.guest.model;

import com.rmeunier.hotelapp.user.HotelUser;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Guest extends HotelUser {
    @Column(name = "first_name", columnDefinition = "TEXT")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "TEXT")
    private String lastName;
    @OneToOne
    @JoinColumn(name = "home_address_id")
    private HomeAddress homeAddress;
    @Column(name = "phone")
    private String phone;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Transient
    private int age;

    public Guest(@NonNull String email, @NonNull String password, String lastName, String firstName, String phone, LocalDate dateOfBirth, int age) {
        super(email, password);
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

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

    public void setAge() {
        this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

}
