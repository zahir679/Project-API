package com.bluechickenfm.album;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AlbumRowMapper implements RowMapper<Album> {

    @Override
    public Album mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Album(
                resultSet.getInt("id"),
                resultSet.getString("album_name"),
                resultSet.getString("artist_id"),
                LocalDate.parse(resultSet.getString("release_date"))
        );
    }
}