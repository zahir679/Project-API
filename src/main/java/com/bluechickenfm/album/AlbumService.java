package com.bluechickenfm.album;

import com.bluechickenfm.song.Song;

import java.util.List;

public class AlbumService {

    private AlbumDAO albumDAO;

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
