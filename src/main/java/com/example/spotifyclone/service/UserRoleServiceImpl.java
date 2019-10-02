package com.example.spotifyclone.service;


import com.example.spotifyclone.model.User;
import com.example.spotifyclone.model.UserRole;
import com.example.spotifyclone.respositories.UserRepository;
import com.example.spotifyclone.respositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole createRole(UserRole newRole) {
        return userRoleRepository.save(newRole);
    }

    @Override
    public UserRole getRole(String roleName) {
        return userRoleRepository.findByName(roleName);
    }

}
