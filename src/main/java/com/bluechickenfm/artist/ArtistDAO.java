package com.bluechickenfm.artist;

import java.util.List;

public interface ArtistDAO {
    List<Artist> getArtistById(int id);
    List<Artist> getAllArtists();
    int addArtist(Artist artist);
    int updateArtist(int id, Artist artist);
    int deleteArtist(int id);
}
