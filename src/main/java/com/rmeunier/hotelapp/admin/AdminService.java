package com.rmeunier.hotelapp.admin;

import com.rmeunier.hotelapp.admin.model.Admin;
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
    public void updateAdmin(Long id, Admin admin) {
        Admin adminInDb = adminRepository.findById(id)
               .orElseThrow(() -> new AdminNotFoundException("Admin of " + id + " not found."));

        adminInDb.setEmail(admin.getEmail());
        adminInDb.setPassword(admin.getPassword());
        adminInDb.setRole(admin.getRole());
    }
}
