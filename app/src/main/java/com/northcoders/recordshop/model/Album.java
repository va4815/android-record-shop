package com.northcoders.recordshop.model;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private Long id;
    private String name;
    private String releasedDate;
    private Genre genre;
    private List<Song> songs = new ArrayList<>();

    public Album(Long id, String name, String releasedDate, Genre genre, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.songs = songs;
    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
