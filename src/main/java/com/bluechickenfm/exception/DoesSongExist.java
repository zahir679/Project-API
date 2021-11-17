package com.bluechickenfm.exception;

import com.bluechickenfm.song.Song;
import com.bluechickenfm.song.SongDAO;

import java.util.List;
import java.util.Optional;

public class DoesSongExist {
    private static SongDAO songDAO;

    public static boolean check (int id) {
        Optional<Song> songOptional = songDAO.getSongById(id);
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! Song " + id + " has not been found :( Please try again.");
        }
        return true;
    }
}