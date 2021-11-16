package com.bluechickenfm.artist;

import com.bluechickenfm.album.Album;
import com.bluechickenfm.album.AlbumService;
import com.bluechickenfm.song.Song;
import com.bluechickenfm.song.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class ArtistController {
   /* private ArtistService artistService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    //GET
    //Method to get all albums
    @GetMapping("/albums")
    public @ResponseBody
    List<Album> getAllAlbums(){
        return this.albumService.getAllAlbums();
    }

    //Method to get a single album by its id (primary key)
    @GetMapping("/albums/{id}")
    public @ResponseBody
    List<Album> getAlbumById(@PathVariable int id){
        return AlbumService.getAlbumById(id);
    }

//    //Method to get albums by name
//    @GetMapping("/albums/name")
//    public @ResponseBody
//    List<Album> getAlbumByName(String name){
//        return albumService.getAlbumByName(name);
//    }

//        //Method to get albums by artist_id
//    @GetMapping("/albums/artist/{artist_id}")
//    public @ResponseBody List<Album> getAlbumsByArtist(@PathVariable int artist_id){
//        return albumService.getAlbumsByArtist(artist_id);
//    }

//        //Method to get albums by genre
//    @GetMapping("/albums/{genre}")
//    public @ResponseBody List<Song> getAlbumsByGenre(@PathVariable String genre){
//        return albumService.getAlbumsByGenre(genre);
//    }

//        //Method to get albums by year
//    @GetMapping("/albums/{release_year}")
//    public @ResponseBody List<Album> getAlbumsByYear(@PathVariable int release_year){
//        return albumService.getAlbumsByYear(release_year);
//    }

    //TODO Create a get album by decade function

    //POST
    //Add song
    @PostMapping("/albums/add")
    public void addAlbum(@RequestBody Album album) {
        albumService.addAlbum(album);
    }

    //PUT
    //Method to update a whole album
    @PutMapping("/albums/{id}")
    public void updateAlbum(@PathVariable int id,
                            @RequestBody Album album) {
        albumService.updateAlbum(id, album);
    }

    //DELETE
    //Method to delete an album
    @DeleteMapping("/albums/{id}")
    public void deleteAlbum(@PathVariable int id) {
        albumService.deleteAlbum(id);
    }
*/
}