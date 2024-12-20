package com.northcoders.recordshop.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshop.BR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Album extends BaseObservable implements Parcelable {
    private Long id;
    private String name;
    private String releasedDate;

    private String genre;
    private Genre displayGenre;
    private List<Song> songs = new ArrayList<>();
    private List<Long> artistIds = new ArrayList<>();

    public Album(Long id, String name, String releasedDate, String genre, Genre displayGenre, List<Song> songs, List<Long> artistIds) {
        this.id = id;
        this.name = name;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.displayGenre = displayGenre;
        this.songs = songs;
        this.artistIds = artistIds;
    }

    public Album() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(releasedDate);
        dest.writeString(genre);
        dest.writeString(displayGenre.name());
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
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public Genre getDisplayGenre() {
        return displayGenre;
    }

    public void setDisplayGenre(Genre displayGenre) {
        this.displayGenre = displayGenre;
        notifyPropertyChanged(BR.displayGenre);
    }

    @Bindable
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
        notifyPropertyChanged(BR.songs);
    }

    @Bindable
    public List<Long> getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(List<Long> artistIds) {
        this.artistIds = artistIds;
        notifyPropertyChanged(BR.artistIds);
    }
}
