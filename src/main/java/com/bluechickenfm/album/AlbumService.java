package com.bluechickenfm.album;

import com.bluechickenfm.song.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumService {

    private AlbumDAO albumDAO;
    @Autowired
    public AlbumService(@Qualifier("chicken") AlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }

    public List<Album> getAlbumById(int id) {
        return this.albumDAO.getAlbumById(id);
    }

    public List<Album> getAllAlbums() {
        return this.albumDAO.getAllAlbums();
    }


    public void addAlbum(Album album) {
        this.albumDAO.addAlbum(album);
    }

    public void updateAlbum(int id, Album album) {
        this.albumDAO.updateAlbum(id, album);
    }

    public void deleteAlbum(int id) {
        this.albumDAO.deleteAlbum(id);
    }


}
