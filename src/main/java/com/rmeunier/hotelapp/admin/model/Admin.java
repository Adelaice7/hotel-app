package com.rmeunier.hotelapp.admin.model;

import com.rmeunier.hotelapp.user.HotelUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admin")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Admin extends HotelUser {
    private String role;

    public Admin(String email, String password, String role) {
        super(email, password);
        this.role = role;
    }
}
