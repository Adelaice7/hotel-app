package com.rmeunier.hotelapp.admin.model;

import com.rmeunier.hotelapp.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin extends User {
    private String role;

    public Admin(String email, String password, String role) {
        super(email, password);
        this.role = role;
    }
}
