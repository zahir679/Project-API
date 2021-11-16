package com.bluechickenfm.artist;

import com.bluechickenfm.album.AlbumRowMapper;

import com.bluechickenfm.song.SongRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("chicken")
public class ArtistDataAccessService implements ArtistDAO{
    private JdbcTemplate jdbcTemplate;

    public List<Artist> getArtistById(int id){
        var sql = """
                SELECT * FROM artists
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new ArtistRowMapper(), id);
    };
    public List<Artist> getAllArtists(){
        var sql = """
                SELECT * FROM artists
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new ArtistRowMapper());

    };
    public int addArtist(Artist artist){
        var sql = """
                INSERT INTO artists(artist_name, nationality, biggest_hit)
                VALUES (?, ?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                artist.getArtist_name(), artist.getNationality(), artist.getBiggest_hit()
        );

    };
    public int updateArtist(int id, Artist artist){
        var sql = """
                    UPDATE artists
                    SET artist_name=?, nationality=?, biggest_hit=?
                    WHERE id = ? """;
        return jdbcTemplate.update(sql,artist.getArtist_name(), artist.getNationality(), artist.getBiggest_hit()
        );
    };
    public int deleteArtist(int id){
        var sql = """
                DELETE FROM artist
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    };
}
