package com.example.spotifyclone.Controller;

import com.example.spotifyclone.model.Song;
import com.example.spotifyclone.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping
    public Song createSong(@RequestBody Song song){
        return songService.createSong(song);
    }

    @GetMapping("/list/song")
    public Iterable<Song> listTitle(){
        return songService.listTitle();
    }

    @DeleteMapping("/songs/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long songId){
        return songService.deleteById(songId);
    }
}
