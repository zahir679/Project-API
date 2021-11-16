package com.bluechickenfm.song;

import java.util.List;
import java.util.Optional;

public interface SongDAO {

    List<Song> getAllSongs();
    Optional<Song> getSongById(int id);
//    List<Song> getSongsByArtist(int artist_id);
//    List<Song> getSongsByAlbum(int release_year);
//    List<Song> getSongsByGenre(String genre);
//    List<Song> getSongsByDecade(int release_decade);
    int addSong(Song song);
    int updateSong(int id, Song song);
    int deleteSong(int id);
//    List<Song> getSongsByYear(int release_year);
    List<Song> getSongByName(String name);

}
