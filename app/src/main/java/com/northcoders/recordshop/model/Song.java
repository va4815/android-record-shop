package com.northcoders.recordshop.model;

public class Song {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public long getSongLength() {
        return songLength;
    }

    public void setSongLength(long songLength) {
        this.songLength = songLength;
    }
}
