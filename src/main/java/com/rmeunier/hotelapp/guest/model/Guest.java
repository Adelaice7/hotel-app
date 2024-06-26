package com.rmeunier.hotelapp.guest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "guest")
public class Guest {
    @Id
    @SequenceGenerator(name = "guest_id_seq", sequenceName = "guest_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "guest_id_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    @JoinColumn(name = "home_address_id")
    private HomeAddress homeAddress;
    private String phone;
    private LocalDate dateOfBirth;
    @Transient
    private int age;

    public Guest(String firstName, String lastName, String email, String phone, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    private void setAge() {
        this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

}
