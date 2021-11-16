package com.bluechickenfm.song;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//public class SongDataAccessService {
@Repository("chicken")
    public class SongDataAccessService implements SongDAO{

        private JdbcTemplate jdbcTemplate;
    //        private final JdbcTemplate jdbcTemplate;

        public SongDataAccessService(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public List<Song> getAllSongs() {
            var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                LIMIT 100;
                 """;
            return jdbcTemplate.query(sql, new SongRowMapper());
        }

        @Override
        public int addSong(Song song) {
            var sql = """
                INSERT INTO songs(song_name, genre, duration, artist_id, album_id, release_date, languages, platform)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                 """;
            return jdbcTemplate.update(
                    sql,
                    song.getSong_name(), song.getGenre(), song.getDuration(), song.getArtist_id(), song.getAlbum_id()
                    , song.getRelease_date(), song.getLanguage(), song.getPlatform()
            );
        }

        @Override
        public int updateSong(int id, Song song){
            var sql = """
                    UPDATE songs
                    SET song_name=?, genre=?, duration=?, artist_id=?, album_id=?, release_date=?, languages=?, platform=?
                    WHERE id = ? """;
            return jdbcTemplate.update(sql,song.getSong_name(), song.getGenre(), song.getDuration(),
                    song.getArtist_id(), song.getAlbum_id(), song.getRelease_date(), song.getLanguage(), song.getPlatform(),
                    song.getId());

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
        public Song getSongById(int id) {
            var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform,
                FROM songs
                WHERE id = ?
                 """;
            return jdbcTemplate.query(sql, new SongRowMapper(), id);
        }

        @Override
        public List<Song> getSongByName(String name) {
            var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform,
                FROM songs
                WHERE name = ?
                 """;
            return jdbcTemplate.query(sql, new SongRowMapper(), name);
        }
    }

