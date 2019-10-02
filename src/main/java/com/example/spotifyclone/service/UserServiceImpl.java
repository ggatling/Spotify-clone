package com.example.spotifyclone.service;


import com.example.spotifyclone.model.Song;
import com.example.spotifyclone.model.User;
import com.example.spotifyclone.model.UserRole;
import com.example.spotifyclone.respositories.SongRepository;
import com.example.spotifyclone.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserRoleService userRoleService;

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {
        UserRole userRole = userRoleService.getRole(newUser.getUserRole().getName());
        newUser.setUserRole(userRole);
        newUser.setPassword(newUser.getPassword());
        return userRepository.save(newUser);

    }

    @Override
    public User login(String username, String password){
        return userRepository.login(username, password);
    }

    @Override
    public HttpStatus deleteById(Long userId){
        userRepository.deleteById(userId);
        return null;
    }

    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }

    @Autowired
    SongRepository songRepository;

    @Override
    public User addSong(String username, Long songId) {
        Song song = songRepository.findById(songId).get();
        User user = getUser(username);
        user.addSongs(song);

        return userRepository.save(user);
    }

}
