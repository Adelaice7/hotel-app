package com.rmeunier.hotelapp.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "hotel_user")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "hotel_user",
        uniqueConstraints = @UniqueConstraint(name = "user_email_constraint", columnNames = {"email"}))
public abstract class HotelUser {
    @Id
    @SequenceGenerator(name = "hotel_user_id_seq", sequenceName = "hotel_user_id_", allocationSize = 1)
    @GeneratedValue(generator = "hotel_user_id_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @NonNull
    @Column(name = "email")
    private String email;
    @NonNull
    @Column(name = "password")
    private String password;
}
