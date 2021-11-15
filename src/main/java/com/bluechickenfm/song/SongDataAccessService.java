package com.bluechickenfm.song;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//public class SongDataAccessService {

    @Repository
    public class SongDataAccessService implements SongDAO {

        private final JdbcTemplate jdbcTemplate;

        public SongDataAccessService(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public List<Song> getAllSongs() {
            var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform,
                FROM songs
                LIMIT 100;
                 """;
            return jdbcTemplate.query(sql, new SongRowMapper());
        }

        @Override
        public int addSong(Song song) {
            var sql = """
                INSERT INTO songs(song_name, genre, duration, artist_id, album_id, release_date, languages, platform,)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                 """;
            return jdbcTemplate.update(
                    sql,
                    song.getName(), song.getGenre(), song.getDuration(), song.getArtist_id(), song.getAlbum_id()
                    , song.getRelease_date(), song.getRelease_year(), song.getLanguage()
            );
        }

        @Override
        public int deleteSong(int id) {
            var sql = """
                DELETE FROM songs
                WHERE id = ?
                """;
            return jdbcTemplate.update(sql, id);
        }

        @Override
        public Optional<Song> getSongById(int id) {
            var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform,
                FROM songs
                WHERE id = ?
                 """;
            return jdbcTemplate.query(sql, new SongRowMapper(), id)
                    .stream()
                    .findFirst();
        }

        @Override
        public Optional<Song> getSongByName(String name) {

        }

    }

