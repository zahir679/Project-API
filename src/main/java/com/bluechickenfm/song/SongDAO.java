package com.bluechickenfm.song;

import java.time.LocalDate;
import java.util.List;

public interface SongDAO {

    List<Song> getAllSongs();

    Song getSongById(int id)

    List<Song> getSongsByArtist(int artist_id);

    List<Song> getSongsByAlbum(int release_year);

    List<Song> getSongsByGenre(String genre);

    List<Song> getSongsByDecade(int release_decade);

    void addSong(Song song);

    void updateSong(Song song);

    void updateSongName(int id, String name);

    void updateSongGenre();

    void updateSongDuration();

    void updateSongLanguage();

    void updateSongArtistId();

    void updateSongAlbumId();

    void deleteSong();

    void updateSongReleaseDate(int id, LocalDate release_date);

    List<Song> getSongsByYear(int release_year);
}
