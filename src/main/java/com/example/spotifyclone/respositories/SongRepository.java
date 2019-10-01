//package com.example.spotifyclone.respositories;
//
//import com.example.spotifyclone.model.Song;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//public interface SongRepository extends CrudRepository {
//    @Query("SELECT t FROM Song t WHERE title = ?1 and artist =?2")
//            public Song song(String title, String artist);
//}
