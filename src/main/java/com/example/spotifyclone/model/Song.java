package com.example.spotifyclone.model;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String songTitle;

    @Column
    private double songLength;

    public Song (){}

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getSongTitle(){
        return songTitle;
    }

    public void setSongTitle(){
        this.songTitle = songTitle;
    }

    public double getSongLength(){
        return songLength;
    }

    public void setSongLength(){
        this.songLength = songLength;
    }

}
