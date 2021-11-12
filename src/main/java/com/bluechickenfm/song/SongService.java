package com.bluechickenfm.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongDAO songDAO;

    @Autowired
    public SongService(@Qualifier("chicken") SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    //GET


    public List<Song> getAllSongs() {
        return songDAO.getAllSongs();
    }

    public Optional<Song> getSongById(int id) {
        return songDAO.getSongById(id);
    }

//    public List<Song> getSongsByArtist(int artist_id) {
//        return songDAO.getSongsByArtist(artist_id);
//    }
//
//    public List<Song> getSongsByAlbum(int album_id) {
//        return songDAO.getSongsByAlbum(album_id);
//    }
//
//    public List<Song> getSongsByGenre(String genre) {
//        return songDAO.getSongsByGenre(genre);
//    }
//
//    public List<Song> getSongsByYear(int release_year) {
//        return songDAO.getSongsByAlbum(release_year);
//    }
//
//    public List<Song> getSongsByDecade(int release_decade) {
//        return songDAO.getSongsByDecade(release_decade);
//    }

    //POST
    public void addSong(Song song) {
        songDAO.addSong(song);
    }

//    //PUT
//    public void updateSong(int id, Song song) {
//        songDAO.updateSong(song);
//    }
//
//    public void updateSongName(int id, String name) {
//        songDAO.updateSongName(id, name);
//    }
//
//    public void updateSongGenre(int id, String genre) {
//        songDAO.updateSongGenre();
//    }
//
//    public void updateSongDuration(int id, int duration) {
//        songDAO.updateSongDuration();
//    }
//
//    public void updateSongReleaseDate(int id, LocalDate release_date) {
//        songDAO.updateSongReleaseDate(id, release_date);
//    }
//
//    public void updateSongLanguage(int id, String language) {
//        songDAO.updateSongLanguage();
//    }
//
//    public void updateSongArtistId(int id, int artist_id) {
//        songDAO.updateSongArtistId();
//    }
//
//    public void updateSongAlbumId(int id, String album_id) {
//        songDAO.updateSongAlbumId();
//    }

    //DELETE
    public void deleteSong(int id) { songDAO.deleteSong(id); }
}
