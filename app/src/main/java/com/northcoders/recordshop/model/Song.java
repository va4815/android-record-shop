package com.northcoders.recordshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshop.BR;

public class Song extends BaseObservable {
    private Long id;
    private String title;
    private String writer;
    private long songLength;

    public Song(Long id, String title, String writer, long songLength) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.songLength = songLength;
    }


    public Song() {
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
        notifyPropertyChanged(BR.writer);
    }

    @Bindable
    public long getSongLength() {
        return songLength;
    }

    public void setSongLength(long songLength) {
        this.songLength = songLength;
        notifyPropertyChanged(BR.songLength);
    }
}
