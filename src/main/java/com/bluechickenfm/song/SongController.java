package com.bluechickenfm.song;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    //GET
    @GetMapping("/songs")
    public @ResponseBody List<Song> getAllSongs(){
        return songService.getAllSongs();
    }
    //POST
    @PostMapping
    public

    //PUT
    @PutMapping

    //DELETE
    @DeleteMapping
}
