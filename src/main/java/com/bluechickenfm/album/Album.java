package com.bluechickenfm.album;

import java.time.LocalDate;
import java.util.Objects;

public class Album {
    private String name;
    private String artistId;
    private String genre;
    private LocalDate releaseDate;
    private int numberOfTracks;

    public Album(String name, String artistId, String genre, LocalDate releaseDate, int numberOfTracks) {
        this.name = name;
        this.artistId = artistId;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artistId='" + artistId + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + releaseDate +
                ", numberOfTracks=" + numberOfTracks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return numberOfTracks == album.numberOfTracks && Objects.equals(name, album.name) && Objects.equals(artistId, album.artistId) && Objects.equals(genre, album.genre) && Objects.equals(releaseDate, album.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artistId, genre, releaseDate, numberOfTracks);
    }
}