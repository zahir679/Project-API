package com.bluechickenfm.exception;

import com.bluechickenfm.song.Song;
import com.bluechickenfm.song.SongDAO;

import java.util.Optional;

public class DoesSongExist {
    private static SongDAO songDAO;

    public static void check (int id) {
        Optional<Song> songOptional = songDAO.getSongById(id);
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! Song with id " + id + " has not been found :( Please try again.");
        }
    }
}