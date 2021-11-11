package com.bluechickenfm.song;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        return songService.getSongById(id);
    }

    @GetMapping("/songs/{artist_id}")
    public @ResponseBody List<Song> getSongsByArtist(@PathVariable int artist_id){
        return songService.getSongsByArtist(artist_id);
    }

    @GetMapping("/songs/{album_id}")
    public @ResponseBody List<Song> getSongsByAlbum(@PathVariable int album_id){
        return songService.getSongsByAlbum(album_id);
    }

    @GetMapping("/songs/{genre}")
    public @ResponseBody List<Song> getSongsByGenre(@PathVariable String genre){
        return songService.getSongsByGenre(genre);
    }

    @GetMapping("/songs/{release_year}")
    public @ResponseBody List<Song> getSongsByYear(@PathVariable int release_year){
        return songService.getSongsByYear(release_year);
    }

    @GetMapping("/songs/{release_decade}")
    public @ResponseBody List<Song> getSongsByDecade(@PathVariable int release_decade){
        return songService.getSongsByDecade(release_decade);
    }

    //POST
    @PostMapping()
    public void addSong(@RequestBody Song song) {
        songService.addSong(song);
    }

    //PUT
    @PutMapping("/songs/{id}")
    public void updateSong(@PathVariable int id,
                           @RequestBody Song song) {
        songService.updateSong(id, song);
    }

    @PutMapping("/songs/{id}")
    public void updateSongName(@PathVariable int id, String name) {
        songService.updateSongName(id, name);
    }

    @PutMapping("/songs/{id}")
    public void updateSongGenre(@PathVariable int id, String genre) {
        songService.updateSongGenre(id, genre);
    }

    @PutMapping("/songs/{id}")
    public void updateSongArtistId(@PathVariable int id, int artist_id) {
        songService.updateSongArtistId(id, artist_id);
    }

    @PutMapping("/songs/{id}")
    public void updateSongAlbumId(@PathVariable int id, String album_id) {
        songService.updateSongAlbumId(id, album_id);
    }

    @PutMapping("/songs/{id}")
    public void updateSongReleaseDate(@PathVariable int id, LocalDate release_date) {
        songService.updateSongReleaseDate(id, release_date);
    }

    @PutMapping("/songs/{id}")
    public void updateSongLanguage(@PathVariable int id, String language) {
        songService.updateSongLanguage(id, language);
    }

    //DELETE
    @DeleteMapping("/songs/{id}")
    public void deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
    }
}
