package com.rmeunier.hotelapp.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class HotelUserController {

    private final HotelUserService userService;

    public HotelUserController(HotelUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<HotelUser> getAllUsers() {
        return userService.getAllUsers();
    }
}
