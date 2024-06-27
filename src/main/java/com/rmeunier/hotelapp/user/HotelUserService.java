package com.rmeunier.hotelapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelUserService {

    private final HotelUserRepository userRepository;

//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public HotelUserService(HotelUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<HotelUser> getAllUsers() {
        return userRepository.findAll();
    }

    public HotelUser getUserById(Long id) {
        return userRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    public HotelUser saveUser(HotelUser user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
}
