package com.dkey.services;

import com.dkey.entities.Admin;
import com.dkey.exceptions.AdminNotFoundException;
import com.dkey.exceptions.UsernameCannotBeUseException;
import com.dkey.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin admin) {
        if (isAdminExist(admin.getUsername()))
            throw new UsernameCannotBeUseException();
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        if(!isAdminExist(username))
           throw new AdminNotFoundException();
        return adminRepository.getOne(username);
    }

    private Boolean isAdminExist(String username){
        return adminRepository.findById(username).isPresent();
    }

    @Override
    public void deleteAdmin(String username) {
        adminRepository.deleteById(username);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return this.createAdmin(admin);
    }
}
