package com.rmeunier.hotelapp.admin;

import com.rmeunier.hotelapp.admin.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    public void updateAdmin(Long id,
                            @RequestParam(value = "email", required = false) String email,
                            @RequestParam(value = "password", required = false) String password,
                            @RequestParam(value = "role", required = false) String role) {
        adminService.updateAdmin(id, email, password, role);
    }
}
