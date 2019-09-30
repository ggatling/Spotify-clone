package com.example.spotifyclone.respositories;

import com.example.spotify.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long>{
}
