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
//    void updateSongName(int id, String name);
//    void updateSongGenre();
//    void updateSongDuration();
//    void updateSongLanguage();
//    void updateSongArtistId();
//    void updateSongAlbumId();
    int deleteSong(int id);
//    void updateSongReleaseDate(int id, LocalDate release_date);
//    List<Song> getSongsByYear(int release_year);
}
