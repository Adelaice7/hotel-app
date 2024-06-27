package com.rmeunier.hotelapp.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelUserRepository extends JpaRepository<HotelUser, Long> {
}
