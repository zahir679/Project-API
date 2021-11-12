package com.bluechickenfm.artist;

import java.util.Objects;

public class Artist {
    private String name;
    private String nationality;
    private String biggestHit;

    public Artist(String name, String nationality, String biggestHit) {
        this.name = name;
        this.nationality = nationality;
        this.biggestHit = biggestHit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiggestHit() {
        return biggestHit;
    }

    public void setBiggestHit(String biggestHit) {
        this.biggestHit = biggestHit;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", biggestHit='" + biggestHit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name) && Objects.equals(nationality, artist.nationality) && Objects.equals(biggestHit, artist.biggestHit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality, biggestHit);
    }
}