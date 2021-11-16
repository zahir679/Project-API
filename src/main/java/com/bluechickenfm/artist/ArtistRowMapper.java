package com.bluechickenfm.artist;

import com.bluechickenfm.album.Album;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ArtistRowMapper implements RowMapper<Artist> {
    @Override
    public Artist mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Artist(
                resultSet.getInt("id"),
                resultSet.getString("artist_name"),
                resultSet.getString("nationality"),
                resultSet.getString("biggest_hit")
        );
    }
}
