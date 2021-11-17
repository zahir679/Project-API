package com.bluechickenfm.album;

import com.bluechickenfm.exception.BadRequest;
import com.bluechickenfm.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    private AlbumDAO albumDAO;
    @Autowired
    public AlbumService(@Qualifier("chickenAlbum") AlbumDAO albumDAO) {
        this.albumDAO = albumDAO;
    }

    public List<Album> getAlbumById(int id) {
        return this.albumDAO.getAlbumById(id);
    }

    public List<Album> getAllAlbums() {
        return this.albumDAO.getAllAlbums();
    }


    public void addAlbum(Album album) {
        this.albumDAO.addAlbum(album);
    }

    public void updateAlbum(int id, Album album) {
        this.albumDAO.updateAlbum(id, album);
    }

    public void deleteAlbum(int id) {
        this.albumDAO.deleteAlbum(id);
    }


    public List<Album> getAlbumByName(String name) {
        Optional<List<Album>> albumByNameOptional = Optional.ofNullable(albumDAO.getAlbumByName(name));
        if(albumByNameOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! The album " + name + " has not been found :( Please try again.");
        }
        return albumDAO.getAlbumByName(name);
    }

    public List<Album> getAlbumsByArtist(int artist_id) {
        Optional<List<Album>> albumByArtistOptional = Optional.ofNullable(albumDAO.getAlbumsByArtist(artist_id));
        if(albumByArtistOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! An album by artist " + artist_id + " has not been found :( Please try again.");
        }
        return albumDAO.getAlbumsByArtist(artist_id);
    }

    public List<Album> getAlbumsByArtistName(String artist_name) {
        Optional<List<Album>> albumByArtistOptional = Optional.ofNullable(albumDAO.getAlbumsByArtistName(artist_name));
        if(albumByArtistOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! An album by artist " + artist_name + " has not been found :( Please try again.");
        }
        return albumDAO.getAlbumsByArtistName(artist_name);
    }

    public List<Album> getAlbumsByGenre(String genre) {
        Optional<List<Album>> albumByGenreOptional = Optional.ofNullable(albumDAO.getAlbumsByGenre(genre));
        if(albumByGenreOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry, your music taste is too unique. An album with the genre " + genre + " has not been found :(");
        }
        return albumDAO.getAlbumsByGenre(genre);
    }

    public List<Album> getAlbumsByYear(int release_year) {
        LocalDate start_date = LocalDate.parse(release_year + "-01-01");
        LocalDate end_date = LocalDate.parse(release_year + "-12-31");

        Optional<List<Album>> albumByYearOptional = Optional.ofNullable(albumDAO.getAlbumsByYear(start_date, end_date));
        if(albumByYearOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! No albums found for " + release_year + " :( Please try again.");
        }

        return albumDAO.getAlbumsByYear(start_date, end_date);
    }

    public List<Album> getAlbumsByDecade(int release_decade) {
        //Exception to check valid input decade - 4 digits and ends in 0
        if((String.valueOf(release_decade).length() == 4) && release_decade % 10 != 0){
            throw new BadRequest("Please enter a valid decade in format yyy0");
        }

        LocalDate start_date = LocalDate.parse(release_decade + "-01-01");
        LocalDate end_date = LocalDate.parse((release_decade+9) + "-12-31");

        Optional<List<Album>> albumByDecadeOptional = Optional.ofNullable(albumDAO.getAlbumsByDecade(start_date, end_date));
        if(albumByDecadeOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! No albums found for " + release_decade + "s :( Please try again.");
        }
        return albumDAO.getAlbumsByDecade(start_date, end_date);
    }

    public List<Album> getAlbumsByGenreAndDecade(String genre, int release_decade) {
        List<Album> albumsByGenreDecade = getAlbumsByDecade(release_decade)
                .stream()
                .filter(album -> album.getGenre().toLowerCase().equals(genre.toLowerCase()))
                .collect(Collectors.toList());

        Optional<List<Album>> albumOptional = Optional.of(albumsByGenreDecade);
        if(albumOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! There are no albums from the " + release_decade + "s of the genre " + genre);
        }
        return albumsByGenreDecade;
    }
}
//
//    public List<Song> getSongsByGenreDecade(String genre, int release_decade) {
//        List<Song> songsByDecade = getSongsByDecade(release_decade);
//        List<Song> songsByGenreDecade = songsByDecade.stream().filter(song -> song.getGenre() == genre).collect(Collectors.toList());
//
//        Optional<List<Song>> songOptional = Optional.ofNullable(songsByGenreDecade);
//        if(songOptional.isEmpty()){
//            throw new ResourceNotFound("Sorry! There are no songs from the " + release_decade + "s of the genre " + genre);
//        }
//        return songsByGenreDecade;
//    }