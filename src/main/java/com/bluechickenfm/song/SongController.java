package com.bluechickenfm.song;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    //GET
    //Method to get all songs
    @GetMapping("/songs")
    public @ResponseBody List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    //Method to get a single song by its id (primary key)
    @GetMapping("/songs/{id}")
    public @ResponseBody
    Optional<Song> getSongById(@PathVariable int id){
        return songService.getSongById(id);
    }

    //Method to get songs by artist_id
    @GetMapping("/songs/{artist_id}")
    public @ResponseBody List<Song> getSongsByArtist(@PathVariable int artist_id){
        return songService.getSongsByArtist(artist_id);
    }

    //Method to get songs by album_id
    @GetMapping("/songs/{album_id}")
    public @ResponseBody List<Song> getSongsByAlbum(@PathVariable int album_id){
        return songService.getSongsByAlbum(album_id);
    }

    //Method to get songs by genre
    @GetMapping("/songs/{genre}")
    public @ResponseBody List<Song> getSongsByGenre(@PathVariable String genre){
        return songService.getSongsByGenre(genre);
    }

    //Method to get songs by year
    @GetMapping("/songs/{release_year}")
    public @ResponseBody List<Song> getSongsByYear(@PathVariable int release_year){
        return songService.getSongsByYear(release_year);
    }

    //Method to get songs by decade
    @GetMapping("/songs/{release_decade}")
    public @ResponseBody List<Song> getSongsByDecade(@PathVariable int release_decade){
        return songService.getSongsByDecade(release_decade);
    }

    //POST
    //Add song
    @PostMapping()
    public void addSong(@RequestBody Song song) {
        songService.addSong(song);
    }

    //PUT
    //Method to update a whole song
    @PutMapping("/songs/{id}")
    public void updateSong(@PathVariable int id,
                           @RequestBody Song song) {
        songService.updateSong(id, song);
    }

    //Method to update a given song's name
    @PutMapping("/songs/{id}")
    public void updateSongName(@PathVariable int id, String name) {
        songService.updateSongName(id, name);
    }

    //Method to update a given song's genre
    @PutMapping("/songs/{id}")
    public void updateSongGenre(@PathVariable int id, String genre) {
        songService.updateSongGenre(id, genre);
    }

    //Method to update a given song's artist_id
    @PutMapping("/songs/{id}")
    public void updateSongArtistId(@PathVariable int id, int artist_id) {
        songService.updateSongArtistId(id, artist_id);
    }

    //Method to update a given song's album_id
    @PutMapping("/songs/{id}")
    public void updateSongAlbumId(@PathVariable int id, String album_id) {
        songService.updateSongAlbumId(id, album_id);
    }

    //Method to update a given song's release date
    @PutMapping("/songs/{id}")
    public void updateSongReleaseDate(@PathVariable int id, LocalDate release_date) {
        songService.updateSongReleaseDate(id, release_date);
    }

    //Method to update a given song's language
    @PutMapping("/songs/{id}")
    public void updateSongLanguage(@PathVariable int id, String language) {
        songService.updateSongLanguage(id, language);
    }

    //DELETE
    //Method to delete a song
    @DeleteMapping("/songs/{id}")
    public void deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
    }
}
