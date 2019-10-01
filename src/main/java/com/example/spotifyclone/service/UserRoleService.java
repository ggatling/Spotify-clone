package com.example.spotifyclone.service;

import com.example.spotifyclone.model.UserRole;

public interface UserRoleService {
    public UserRole createRole(UserRole newRole);

    public UserRole getRole(String roleName);
}
