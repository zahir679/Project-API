package com.bluechickenfm.song;

import com.bluechickenfm.exception.Conflict;
import com.bluechickenfm.exception.DoesSongExist;
import com.bluechickenfm.exception.ResourceNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getAllSongs());
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs available right now :(");
        }
        return songDAO.getAllSongs();
    }

    public Optional<Song> getSongById(int id) {
        return Optional.ofNullable(songDAO.getSongById(id)
                .orElseThrow(() -> new ResourceNotFound("Song with id " + id + " not found")));
    }
//        Optional<Song> songByIdOptional = Optional.ofNullable(songDAO.getSongById(id));
//        if(songByIdOptional.isEmpty()) {
//            //TODO: return name of song instead of id
//            throw new ResourceNotFound("Sorry! " + id + " has not been found :( Please try again.");
//        }
//        return songDAO.getSongById(id);

    public List<Song> getSongByName(String name) {
        Optional<List<Song>> songByNameOptional = Optional.ofNullable(songDAO.getSongByName(name));
        if(songByNameOptional.get().isEmpty()){
            throw new ResourceNotFound("Sorry! " + name + " has not been found :( Please try again.");
        }
        return songDAO.getSongByName(name);
    }

//    public List<Song> getSongsByArtist(int artist_id) {
//        Optional<List<Song>> songByArtistOptional = Optional.ofNullable(songDAO.getSongsByArtist(artist_id));
//        if(songByArtistOptional.isEmpty()) {
//            //TODO: return name of artist instead of id
//            throw new ResourceNotFound("Sorry! " + artist_id + " has not been found :( Please try again.");
//        }
//        return songDAO.getSongsByArtist(artist_id);
//    }
//
//    public List<Song> getSongsByAlbum(int album_id) {
//        Optional<List<Song>> songByAlbumOptional = Optional.ofNullable(songDAO.getSongsByArtist(album_id));
//        if(songByAlbumOptional.isEmpty()) {
//            //TODO: return name of album instead of id
//            throw new ResourceNotFound("Sorry! " + album_id + "has not been found :( Please try again.");
//        }
//        return songDAO.getSongsByAlbum(album_id);
//    }
//
//    public List<Song> getSongsByGenre(String genre) {
//        Optional<List<Song>> songByGenreOptional = Optional.ofNullable(songDAO.getSongsByGenre(genre));
//        if(songByGenreOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry, your music taste is too unique. " + genre + " has not been found :(");
//        }
//        return songDAO.getSongsByGenre(genre);
//    }
//
//    public List<Song> getSongsByYear(int release_year) {
//        Optional<List<Song>> songByYearOptional = Optional.ofNullable(songDAO.getSongsByYear(release_year));
//        if(songByYearOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! No songs found for " + release_year + " :( Please try again.");
//        }
//        return songDAO.getSongsByYear(release_year);
//    }
//
//    public List<Song> getSongsByDecade(int release_decade) {
//        Optional<List<Song>> songByDecadeOptional = Optional.ofNullable(songDAO.getSongsByDecade(release_decade));
//        if(songByDecadeOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! No songs found for " + release_decade + ":( Please try again.");
//        }
//        return songDAO.getSongsByDecade(release_decade);
//    }


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
    public String addSong(Song song) {
        //Exception for if song already exists
//        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getSongByName(song.getSong_name()));
//        if (songOptional.isPresent() && songOptional.get().contains(song.getArtist_id())) {
//            throw new Conflict("Song already exists!");
//        }
        songDAO.addSong(song);
        return "Song added";
    }

//    //PUT
public String updateSong(int id, Song song) {
    //check song id exists
    Optional<Song> songOptional = songDAO.getSongById(id);
    if(songOptional.isEmpty()) {
        throw new ResourceNotFound("Sorry! Song with id " + id + " has not been found :(");
    }
    //check update details does not clash with existing song details
    Optional<List<Song>> songOptionalName = Optional.ofNullable(songDAO.getSongByName(song.getSong_name()));
    if (songOptionalName.isPresent() && (songOptionalName.get().contains(song.getArtist_id()))) {
        throw new Conflict("Unable to update song details - song already exists!");
    }
    //check if song is updated in the database
    if(songDAO.updateSong(id, song) == 1) {
        return "Song updated!";
    }
    return "Song not updated...";
    //TODO: make sure updated song is not the same as any other song
}
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
