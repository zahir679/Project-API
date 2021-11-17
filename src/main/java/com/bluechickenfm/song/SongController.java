package com.bluechickenfm.song;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/songs")
public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    //GET
    //Method to get all songs
   @GetMapping
    public @ResponseBody List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    //Method to get a single song by its id (primary key)
    @GetMapping("/{id}")
    public @ResponseBody
    Song getSongById(@PathVariable int id){
        return songService.getSongById(id);
    }

    @GetMapping("/name/{name}")
    public @ResponseBody List<Song> getSongByName(@PathVariable String name){
        return songService.getSongByName(name);
    }

    //Method to get songs by artist_id
    @GetMapping("/artist/{artist_id}")
    public @ResponseBody List<Song> getSongsByArtist(@PathVariable int artist_id){
        return songService.getSongsByArtist(artist_id);
    }

//    //Method to get songs by album_id
    @GetMapping("/album/{album_id}")
    public @ResponseBody List<Song> getSongsByAlbum(@PathVariable int album_id){
        return songService.getSongsByAlbum(album_id);
    }
//
//    //Method to get songs by genre
    @GetMapping("/genre/{genre}")
    public @ResponseBody List<Song> getSongsByGenre(@PathVariable String genre){
        return songService.getSongsByGenre(genre);
    }
//
//    //Method to get songs by year
    @GetMapping("/year/{release_year}")
    public @ResponseBody List<Song> getSongsByYear(@PathVariable int release_year){
        return songService.getSongsByYear(release_year);
    }
//
//    //Method to get songs by decade
    @GetMapping("/decade/{release_decade}")
    public @ResponseBody List<Song> getSongsByDecade(@PathVariable int release_decade){
        return songService.getSongsByDecade(release_decade);
    }

    //POST
    //Add song
    @PostMapping
    public String addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    //PUT
    //Method to update a whole song
    @PutMapping("/{id}")
    public String updateSong(@PathVariable int id,
                           @RequestBody Song song) {
        return songService.updateSong(id, song);
    }


    //DELETE
    //Method to delete a song
    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable int id) {
        return songService.deleteSong(id);
    }
}
