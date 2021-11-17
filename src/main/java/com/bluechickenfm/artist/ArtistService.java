package com.bluechickenfm.artist;

import com.bluechickenfm.album.Album;
import com.bluechickenfm.album.AlbumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistService {

    private ArtistDAO artistDAO;
    @Autowired
    public ArtistService(@Qualifier("chickenArtist") ArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    public List<Artist> getArtistById(int id) {
        return this.artistDAO.getArtistById(id);
    }

    public List<Artist> getAllArtists() {
        return this.artistDAO.getAllArtists();
    }

    public void addArtist(Artist artist) {
        this.artistDAO.addArtist(artist);
    }

    public void updateArtist(int id, Artist artist) {
        this.artistDAO.updateArtist(id, artist);
    }

    public void deleteArtist(int id) {
        this.artistDAO.deleteArtist(id);
    }
}
