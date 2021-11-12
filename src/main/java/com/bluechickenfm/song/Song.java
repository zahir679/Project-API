package com.bluechickenfm.song;

import java.lang.Math;
import java.time.LocalDate;

public class Song {
    private int id;
    private String name;
    private String genre;
    private int duration;
    private int artist_id;
    private int album_id;
    private LocalDate release_date;
    private int release_year;
    private double release_decade;
    private String language;
    //private String platforms;

    public Song() {}

    public Song(String name) {this.name = name;}
//    public Song(int id, String song_name, String genre, int duration, int artist_id, int album_id, LocalDate release_date, String language, String platform){
//    }

    public Song(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Song(int id, String name, String genre, int duration, int artist_id, int album_id, LocalDate release_date, int release_year, double release_decade, String language) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.artist_id = artist_id;
        this.album_id = album_id;
        this.release_date = release_date;
        this.release_year = release_year;
        this.release_decade = release_decade;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", artist_id=" + artist_id +
                ", album_id=" + album_id +
                ", release_date=" + release_date +
                ", language='" + language + '\'' +
                '}';
    }

}

