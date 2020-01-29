package com.dkey.services;

import com.dkey.entities.Admin;

public interface AdminService {
    Admin createAdmin(Admin admin);
    Admin getAdminByUsername(String username);
    void deleteAdmin(String username);
    Admin updateAdmin(Admin admin);
}
