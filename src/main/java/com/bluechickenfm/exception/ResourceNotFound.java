package com.bluechickenfm.exception;

import com.bluechickenfm.song.Song;
import com.bluechickenfm.song.SongDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message){super(message);}
}