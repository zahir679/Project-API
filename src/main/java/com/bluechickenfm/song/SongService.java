package com.bluechickenfm.song;

import com.bluechickenfm.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongDAO songDAO;
    //GET
    public List<Song> getAllSongs() {
        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getAllSongs());
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs available right now :(");
        }
        return songDAO.getAllSongs();
    }

    public Song getSongById(int id) {
        Optional<Song> songByIdOptional = Optional.ofNullable(songDAO.getSongById(id));
        if(songByIdOptional.isEmpty()) {
            //TODO: return name of song instead of id
            throw new ResourceNotFound("Sorry! " + id + " has not been found :( Please try again.");
        }
        return songDAO.getSongById(id);
    }

    public List<Song> getSongsByArtist(int artist_id) {
        Optional<List<Song>> songByArtistOptional = Optional.ofNullable(songDAO.getSongsByArtist(artist_id));
        if(songByArtistOptional.isEmpty()) {
            //TODO: return name of artist instead of id
            throw new ResourceNotFound("Sorry! " + artist_id + " has not been found :( Please try again.");
        }
        return songDAO.getSongsByArtist(artist_id);
    }

    public List<Song> getSongsByAlbum(int album_id) {
        Optional<List<Song>> songByAlbumOptional = Optional.ofNullable(songDAO.getSongsByArtist(album_id));
        if(songByAlbumOptional.isEmpty()) {
            //TODO: return name of album instead of id
            throw new ResourceNotFound("Sorry! " + album_id + "has not been found :( Please try again.");
        }
        return songDAO.getSongsByAlbum(album_id);
    }

    public List<Song> getSongsByGenre(String genre) {
        Optional<List<Song>> songByGenreOptional = Optional.ofNullable(songDAO.getSongsByGenre(genre));
        if(songByGenreOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry, your music taste is too unique. " + genre + " has not been found :(");
        }
        return songDAO.getSongsByGenre(genre);
    }

    public List<Song> getSongsByYear(int release_year) {
        Optional<List<Song>> songByYearOptional = Optional.ofNullable(songDAO.getSongsByYear(release_year));
        if(songByYearOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs found for " + release_year + " :( Please try again.");
        }
        return songDAO.getSongsByYear(release_year);
    }

    public List<Song> getSongsByDecade(int release_decade) {
        Optional<List<Song>> songByDecadeOptional = Optional.ofNullable(songDAO.getSongsByDecade(release_decade));
        if(songByDecadeOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs found for " + release_decade + ":( Please try again.");
        }
        return songDAO.getSongsByDecade(release_decade);
    }

    //POST
    public void addSong(Song song) {
        try {
            songDAO.addSong(song);
        }catch()
    }

    //PUT
    public void updateSong(int id, Song song) {
        Optional<Song> personOptional = SongDAO.getSongById(id);
        if(personOPtional.isEmpty()){
            throw new ResourceNotFound("")
        }
        personDAO.deletePerson(id);
        songDAO.updateSong(song);
    }

    public void updateSongName(int id, String name) {
        songDAO.updateSongName(id, name);
    }

    public void updateSongGenre(int id, String genre) {
        songDAO.updateSongGenre();
    }

    public void updateSongDuration(int id, int duration) {
        songDAO.updateSongDuration();
    }

    public void updateSongReleaseDate(int id, LocalDate release_date) {
        songDAO.updateSongReleaseDate(id, release_date);
    }

    public void updateSongLanguage(int id, String language) {
        songDAO.updateSongLanguage();
    }

    public void updateSongArtistId(int id, int artist_id) {
        songDAO.updateSongArtistId();
    }

    public void updateSongAlbumId(int id, String album_id) {
        songDAO.updateSongAlbumId();
    }

    //DELETE
    public void deleteSong(int id) { songDAO.deleteSong(id); }
}
