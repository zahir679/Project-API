package com.bluechickenfm.song;

import com.bluechickenfm.exception.Conflict;
import com.bluechickenfm.exception.DoesSongExist;
import com.bluechickenfm.exception.InvalidDecade;
import com.bluechickenfm.exception.ResourceNotFound;

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
    public SongService(@Qualifier("chickenSong") SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    //GET
    public List<Song> getAllSongs() {
        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getAllSongs());
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs available right now :(");
        }
        return songDAO.getAllSongs();
    }

    public Song getSongById(int id) {
        return songDAO.getSongById(id)
                .orElseThrow(() -> new ResourceNotFound("Song with id " + id + " does not exist"));
    }

    //TODO return partial matches as well
    public List<Song> getSongByName(String name) {
        Optional<List<Song>> songByNameOptional = Optional.ofNullable(songDAO.getSongByName(name));
        if(songByNameOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! The song " + name + " has not been found :( Please try again.");
        }
        return songDAO.getSongByName(name);
//                .orElseThrow(() -> new ResourceNotFound("Sorry! The song " + name + " has not been found :( Please try again."));
    }


    //TODO return partial matches as well
    public List<Song> getSongsByArtist(int artist_id) {
        Optional<List<Song>> songByArtistOptional = Optional.ofNullable(songDAO.getSongsByArtist(artist_id));
        if(songByArtistOptional.get().isEmpty()) {
            //TODO: return name of artist instead of id
            throw new ResourceNotFound("Sorry! The artist " + artist_id + " has not been found :( Please try again.");
        }
        return songDAO.getSongsByArtist(artist_id);
    }
//
    public List<Song> getSongsByAlbum(int album_id) {
        Optional<List<Song>> songByAlbumOptional = Optional.ofNullable(songDAO.getSongsByArtist(album_id));
        if(songByAlbumOptional.get().isEmpty()) {
            //TODO: return name of album instead of id
            throw new ResourceNotFound("Sorry! Album with id " + album_id + " has not been found :( Please try again.");
        }
        return songDAO.getSongsByAlbum(album_id);
    }
//
    public List<Song> getSongsByGenre(String genre) {
        Optional<List<Song>> songByGenreOptional = Optional.ofNullable(songDAO.getSongsByGenre(genre));
        if(songByGenreOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry, your music taste is too unique. " + genre + " has not been found :(");
        }
        return songDAO.getSongsByGenre(genre);
    }

    public List<Song> getSongsByYear(int release_year) {
        LocalDate start_date = LocalDate.parse(release_year + "-01-01");
        LocalDate end_date = LocalDate.parse(release_year + "-12-31");

        Optional<List<Song>> songByYearOptional = Optional.ofNullable(songDAO.getSongsByYear(start_date, end_date));
        if(songByYearOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs found for " + release_year + " :( Please try again.");
        }

        return songDAO.getSongsByYear(start_date, end_date);
    }

    public List<Song> getSongsByDecade(int release_decade) {
        //Exception to check valid input decade - ends in 0
        if(release_decade % 10 != 0){
            throw new InvalidDecade("Please enter a valid decade in format yyy0");
        }

        LocalDate start_date = LocalDate.parse(release_decade + "-01-01");
        LocalDate end_date = LocalDate.parse((release_decade+9) + "-12-31");

        Optional<List<Song>> songByDecadeOptional = Optional.ofNullable(songDAO.getSongsByDecade(start_date, end_date));
        if(songByDecadeOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs found for " + release_decade + "s :( Please try again.");
        }
        return songDAO.getSongsByDecade(start_date, end_date);
    }

    //POST
    public String addSong(Song song) {
        //If song name and artist for song already exist DO NOT ADD SONG
        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getSongByName(song.getSong_name()));
        if (songOptional.isPresent() && (songOptional.get().contains(song.getArtist_id()))) {
            throw new Conflict("Unable to add song - it already exists!");
        }
        songDAO.addSong(song);
        return "Song added!";
    }

//    //PUT
public String updateSong(int id, Song song) {
//    Optional<Song> songOptional = songDAO.getSongById(id);
//    if(songOptional.isEmpty()) {
//        throw new ResourceNotFound("Sorry! Song with id " + id + " has not been found :(");
//    }
    if(songDAO.updateSong(id, song) == 1) {
        return "Song updated!";
    }
    return "Song not updated...";
    //TODO: make sure updated song is not the same as any other song
}

//    public void updateSongName(int id, String name) {
//        Optional<Song> songOptional = Optional.ofNullable(songDAO.getSongById(id));
//        if(songOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! " + id + " has not been found :( Please try again.");
//        }
//        songDAO.updateSongName(id, name);
//    }
//
//    public void updateSongGenre(int id, String genre) {
//        Optional<Song> songOptional = Optional.ofNullable(songDAO.getSongById(id));
//        if(songOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! " + id + " has not been found :( Please try again.");
//        }
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
    public String deleteSong(int id) {
    //returning null
//        if(DoesSongExist.check(id)) {
//            songDAO.deleteSong(id);
//        }
        songDAO.deleteSong(id);
        return "Song deleted.";
    }
}
