package com.rmeunier.hotelapp.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "hotel_user")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "hotel_user")
public abstract class HotelUser {
    @Id
    @SequenceGenerator(name = "hotel_user_id_seq", sequenceName = "hotel_user_id_", allocationSize = 1)
    @GeneratedValue(generator = "hotel_user_id_seq")
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
