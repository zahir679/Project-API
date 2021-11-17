package com.bluechickenfm.song;

import org.apache.tomcat.jni.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
    public Optional<Song> getSongById(int id) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new SongRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Song> getSongByName(String name) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE song_name LIKE ?
                 """;
        return jdbcTemplate.query(sql, new SongRowMapper(), name+'%');
    }

    //    @Override
    public List<Song> getSongsByArtist(int artist_id) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE artist_id = ?
                 """;
        return jdbcTemplate.query(sql, new SongRowMapper(), artist_id);
    }

    public List<Song> getSongsByAlbum(int album_id) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE album_id = ?
                 """;
        return jdbcTemplate.query(sql, new SongRowMapper(), album_id);
    }

    public List<Song> getSongsByGenre(String genre) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE genre = ?
                 """;
        return jdbcTemplate.query(sql, new SongRowMapper(), genre);
    }

    public List<Song> getSongsByYear(LocalDate start_date, LocalDate end_date) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE release_date >= ? AND release_date <= ?
                 """;
        return jdbcTemplate.query(sql, new SongRowMapper(), start_date, end_date);
    }

    public List<Song> getSongsByDecade(LocalDate start_date, LocalDate end_date) {

            //TODO: variables for decade range
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE release_date >= ? AND release_date <= ?
                 """;
        return jdbcTemplate.query(sql, new SongRowMapper(), start_date, end_date);
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
                    , song.getRelease_date(), song.getLanguages(), song.getPlatform()
            );
        }

        @Override
        public int updateSong(int id, Song song){
            var sql = """
                    UPDATE songs
                    SET song_name=?, genre=?, duration=?, artist_id=?, album_id=?, release_date=?, languages=?, platform=?
                    WHERE id = ?
                    """;
            return jdbcTemplate.update(sql, song.getSong_name(), song.getGenre(), song.getDuration(),
                    song.getArtist_id(), song.getAlbum_id(), song.getRelease_date(), song.getLanguages(), song.getPlatform(),
                    song.getId()
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

}
