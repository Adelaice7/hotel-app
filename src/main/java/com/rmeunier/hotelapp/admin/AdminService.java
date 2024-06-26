package com.rmeunier.hotelapp.admin;

import com.rmeunier.hotelapp.admin.model.Admin;
import com.rmeunier.hotelapp.exception.AdminNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
               .orElseThrow(() -> new AdminNotFoundException("Admin of " + id + " not found."));
    }

    public Admin saveNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdminById(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        } else {
            throw new AdminNotFoundException("Admin of " + id + " not found.");
        }
    }

    @Transactional
    public void updateAdmin(Long id, String email, String password, String role) {
        Admin adminInDb = adminRepository.findById(id)
               .orElseThrow(() -> new AdminNotFoundException("Admin of " + id + " not found."));

        // TODO password encryption + validations

        adminInDb.setEmail(email);
        adminInDb.setPassword(password);
        adminInDb.setRole(role);
    }
}
