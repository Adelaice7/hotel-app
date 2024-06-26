package com.rmeunier.hotelapp.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_", allocationSize = 1)
    @GeneratedValue(generator = "user_id_seq")
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
