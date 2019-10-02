package com.example.spotifyclone.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String artist;

    @Column
    private double length;

    public Song (){}

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(){
        this.artist = artist;
    }

    public double getLength(){
        return length;
    }

    public void setLength(){
        this.length = length;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_songs",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "songs_id"))
    private List<User> users;

    public List<User> getUsers(){ return users; }

    public void setUsers(List<User> users) { this.users = users; }

}
