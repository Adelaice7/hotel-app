package com.rmeunier.hotelapp.admin;

import com.rmeunier.hotelapp.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
