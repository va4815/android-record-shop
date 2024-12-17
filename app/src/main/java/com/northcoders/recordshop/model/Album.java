package com.northcoders.recordshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshop.BR;

import java.util.ArrayList;
import java.util.List;

public class Album extends BaseObservable {
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

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
        notifyPropertyChanged(BR.releasedDate);
    }

    @Bindable
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
        notifyPropertyChanged(BR.songs);
    }
}
