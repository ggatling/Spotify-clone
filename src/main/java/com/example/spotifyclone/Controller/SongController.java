//package com.example.spotifyclone.Controller;
//
//import com.example.spotifyclone.model.Song;
//import com.example.spotifyclone.service.SongService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/songs")
//public class SongController {
//    @Autowired
//    private SongService songService
//
//
//    @DeleteMapping("/songs/{userId}")
//    public HttpStatus deleteUserById(@PathVariable Long songId){
//        return songService.deleteById(songId);
//    }
//}
