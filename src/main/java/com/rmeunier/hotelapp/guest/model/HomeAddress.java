package com.rmeunier.hotelapp.guest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "home_address")
public class HomeAddress {

    @Id
    @SequenceGenerator(name = "home_address_id_seq", sequenceName = "home_address_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "home_address_id_seq")
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public HomeAddress(String street, String city, String state, String zipCode) {}
}
