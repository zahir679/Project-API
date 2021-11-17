package com.bluechickenfm.album;

import com.bluechickenfm.song.Song;
import com.bluechickenfm.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

@RestController
@RequestMapping ("/api/v1/albums")
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    //GET
    //Method to get all albums
    @GetMapping
    public @ResponseBody
    List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    //Method to get a single album by its id (primary key)
    @GetMapping("/{id}")
    public @ResponseBody
    List<Album> getAlbumById(@PathVariable int id){
        return albumService.getAlbumById(id);
    }

    //Method to get albums by name
    @GetMapping("/name/{name}")
    public @ResponseBody List<Album> getAlbumByName(@PathVariable String name){
        return albumService.getAlbumByName(name);
    }

    //Method to get albums by artist_id
    @GetMapping("/artist/{artist_id}")
    public @ResponseBody List<Album> getAlbumsByArtist(@PathVariable int artist_id){
        return albumService.getAlbumsByArtist(artist_id);
    }

    @GetMapping("/artist_name/{artist_name}")
    public @ResponseBody List<Album> getAlbumsByArtistName(@PathVariable String artist_name){
        return albumService.getAlbumsByArtistName(artist_name);
    }

    //Method to get albums by genre
    @GetMapping("/genre/{genre}")
    public @ResponseBody List<Album> getAlbumsByGenre(@PathVariable String genre){
        return albumService.getAlbumsByGenre(genre);
    }

    //Method to get albums by year
    @GetMapping("/year/{release_year}")
    public @ResponseBody List<Album> getAlbumsByYear(@PathVariable int release_year){
        return albumService.getAlbumsByYear(release_year);
    }

    //Method to get albums by decade
    @GetMapping("/decade/{release_decade}")
    public @ResponseBody List<Album> getAlbumsByDecade(@PathVariable int release_decade){
        return albumService.getAlbumsByDecade(release_decade);
    }

    //Method to get albums by decade
    @GetMapping("/genre_decade/{genre}/{release_decade}")
    public @ResponseBody List<Album> getAlbumsByGenreAndDecade(@PathVariable String genre,
                                                               @PathVariable int release_decade){
        return albumService.getAlbumsByGenreAndDecade(genre, release_decade);
    }

    //POST
    //Add song
    @PostMapping("/add")
    public void addAlbum(@RequestBody Album album) {
        albumService.addAlbum(album);
    }

    //PUT
    //Method to update a whole album
    @PutMapping("/{id}")
    public void updateAlbum(@PathVariable int id,
                           @RequestBody Album album) {
        albumService.updateAlbum(id, album);
    }

    //DELETE
    //Method to delete an album
    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable int id) {
        albumService.deleteAlbum(id);
    }

}
