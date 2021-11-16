package com.bluechickenfm.album;

import java.util.List;

public interface AlbumDAO {
    List<Album> getAlbumById(int id);
    List<Album> getAllAlbums();
    int addAlbum(Album album);
    int updateAlbum(int id, Album album);
    int deleteAlbum(int id);
}
