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

    @GetMapping("/songs/{id}")
    public @ResponseBody Song getSongById(@PathVariable int id){
        return songService.getSongById();
    }

    @GetMapping("/songs/{artist_id}")
    public @ResponseBody List<Song> getSongsByArtist(@PathVariable int artist_id){
        return songService.getSongsByArtist();
    }

    @GetMapping("/songs/{album_id}")
    public @ResponseBody List<Song> getSongsByAlbum(@PathVariable int album_id){
        return songService.getSongsByAlbum();
    }

    @GetMapping("/songs/{genre}")
    public @ResponseBody List<Song> getSongsByGenre(@PathVariable String genre){
        return songService.getSongsByGenre();
    }

    @GetMapping("/songs/{release_year}")
    public @ResponseBody List<Song> getSongsByYear(@PathVariable int release_year){
        return songService.getSongsByYear();
    }

    @GetMapping("/songs/{release_decade}")
    public @ResponseBody List<Song> getSongsByDecade(@PathVariable int release_decade){
        return songService.getSongsByDecade();
    }

    //POST
    @PostMapping
    public

    //PUT
    @PutMapping

    //DELETE
    @DeleteMapping
}
