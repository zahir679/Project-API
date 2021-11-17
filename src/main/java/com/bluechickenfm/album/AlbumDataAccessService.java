package com.bluechickenfm.album;

import com.bluechickenfm.song.SongRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("chickenAlbum")
public class AlbumDataAccessService implements AlbumDAO {
    private JdbcTemplate jdbcTemplate;

    public AlbumDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Album> getAlbumById(int id){
        var sql = """
                SELECT * FROM albums
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new AlbumRowMapper(), id);
    };

    @Override
    public List<Album> getAllAlbums(){
        var sql = """
                SELECT * FROM albums;
                 """;
        return jdbcTemplate.query(sql, new AlbumRowMapper());
    };

    @Override
    public int addAlbum(Album album){
        var sql = """
                INSERT INTO albums(album_name, artist_id, genre, release_date, number_of_tracks)
                VALUES (?, ?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                album.getAlbum_name(), album.getArtist_id(), album.getGenre(), album.getRelease_date(), album.getNumber_of_tracks()
        );
    };

    @Override
    public int updateAlbum(int id, Album album){
        var sql = """
                    UPDATE albums
                    SET album_name=?, artist_id=?, genre=?, release_date=?, number_of_tracks=?
                    WHERE id = ? """;
        return jdbcTemplate.update(sql,album.getAlbum_name(), album.getArtist_id(), album.getGenre(),
                album.getRelease_date(), album.getNumber_of_tracks(), album.getId());

    };

    @Override
    public int deleteAlbum(int id){
        var sql = """
                DELETE FROM albums
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    };

}
