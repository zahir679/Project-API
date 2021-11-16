package com.bluechickenfm.song;

import com.bluechickenfm.exception.Conflict;
import com.bluechickenfm.exception.DoesSongExist;
import com.bluechickenfm.exception.ResourceNotFound;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongDAO songDAO;

    @Autowired
    public SongService(@Qualifier("chicken") SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    //GET
    public List<Song> getAllSongs() {
        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getAllSongs());
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs available right now :(");
        }
        return songDAO.getAllSongs();
    }

    public List<Song> getSongById(int id) {
        Optional<List<Song>> songByIdOptional = Optional.ofNullable(songDAO.getSongById(id));
        if(songByIdOptional.isEmpty()) {
            //TODO: return name of song instead of id
            throw new ResourceNotFound("Sorry! " + id + " has not been found :( Please try again.");
        }
        return songDAO.getSongById(id);
    }

    public List<Song> getSongByName(String name) {
        Optional<List<Song>> songByNameOptional = Optional.ofNullable(songDAO.getSongByName(name));
        if(songByNameOptional.isEmpty()){
            throw new ResourceNotFound("Sorry! " + name + " has not been found :( Please try again.");
        }
        return songDAO.getSongByName(name);
    }

//    public List<Song> getSongsByArtist(int artist_id) {
//        Optional<List<Song>> songByArtistOptional = Optional.ofNullable(songDAO.getSongsByArtist(artist_id));
//        if(songByArtistOptional.isEmpty()) {
//            //TODO: return name of artist instead of id
//            throw new ResourceNotFound("Sorry! " + artist_id + " has not been found :( Please try again.");
//        }
//        return songDAO.getSongsByArtist(artist_id);
//    }
//
//    public List<Song> getSongsByAlbum(int album_id) {
//        Optional<List<Song>> songByAlbumOptional = Optional.ofNullable(songDAO.getSongsByArtist(album_id));
//        if(songByAlbumOptional.isEmpty()) {
//            //TODO: return name of album instead of id
//            throw new ResourceNotFound("Sorry! " + album_id + "has not been found :( Please try again.");
//        }
//        return songDAO.getSongsByAlbum(album_id);
//    }
//
//    public List<Song> getSongsByGenre(String genre) {
//        Optional<List<Song>> songByGenreOptional = Optional.ofNullable(songDAO.getSongsByGenre(genre));
//        if(songByGenreOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry, your music taste is too unique. " + genre + " has not been found :(");
//        }
//        return songDAO.getSongsByGenre(genre);
//    }
//
//    public List<Song> getSongsByYear(int release_year) {
//        Optional<List<Song>> songByYearOptional = Optional.ofNullable(songDAO.getSongsByYear(release_year));
//        if(songByYearOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! No songs found for " + release_year + " :( Please try again.");
//        }
//        return songDAO.getSongsByYear(release_year);
//    }
//
//    public List<Song> getSongsByDecade(int release_decade) {
//        Optional<List<Song>> songByDecadeOptional = Optional.ofNullable(songDAO.getSongsByDecade(release_decade));
//        if(songByDecadeOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! No songs found for " + release_decade + ":( Please try again.");
//        }
//        return songDAO.getSongsByDecade(release_decade);
//    }


//    public List<Song> getSongsByArtist(int artist_id) {
//        return songDAO.getSongsByArtist(artist_id);
//    }
//
//    public List<Song> getSongsByAlbum(int album_id) {
//        return songDAO.getSongsByAlbum(album_id);
//    }
//
//    public List<Song> getSongsByGenre(String genre) {
//        return songDAO.getSongsByGenre(genre);
//    }
//
//    public List<Song> getSongsByYear(int release_year) {
//        return songDAO.getSongsByAlbum(release_year);
//    }
//
//    public List<Song> getSongsByDecade(int release_decade) {
//        return songDAO.getSongsByDecade(release_decade);
//    }

    //POST
    public void addSong(Song song) {
        //Exception for if song already exists
        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getSongByName(song.getSong_name()));
        if (songOptional.isPresent() && songOptional.get().contains(song.getArtist_id())) {
            throw new Conflict("Song already exists!");
        }
        songDAO.addSong(song);
    }

//    //PUT
    public void updateSong(int id, Song song) {
        if(DoesSongExist.check(id)) {
            songDAO.updateSong(id, song);
        }
    }

    public void updateSongByPatch(int id, JsonPatch patch) {
        if(DoesSongExist.check(id)) {
            Song song  = songDAO.getSongById(id);
            try {
//                Song songPatched = applyPatchToSong(patch, (Song) song);
                Song songPatched = patch.apply(objectMapper.convertValue(song, JsonNode.class));
                songPatched = objectMapper.treeToValue(songPatched, Song.class);
                songDAO.updateSong(songPatched);
            } catch (JsonPatchException e) {
                e.printStackTrace();
            }

        }
//        } catch (JsonPatchException | JsonProcessingException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        } catch (CustomerNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
    }

//    JsonPatch instance holds the list of operations to be applied to the Target Song
//    Target Song converted into an instance of com.fasterxml.jackson.databind.JsonNode and
//    pass to JsonPatch.apply method to apply the patch
//    JsonPatch.apply deals with applying the operations to the target, returns com.fasterxml.jackson.databind.JsonNode instance
//    objectMapper.treeToValue method binds data in patched com.fasterxml.jackson.databind.JsonNode
//    to Song type = patched Customer instance
//    Finally, we return the patched Customer instance
        public Song applyPatchToSong(JsonPatch patch, Song targetSong)
                throws JsonPatchException, JsonProcessingException {
            JsonNode patched = patch.apply(objectMapper.convertValue(targetSong, JsonNode.class));
            return objectMapper.treeToValue(patched, Song.class);
        }

//    @RequestMapping(value = "/heavyresource/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> partialUpdateGeneric(
//            @RequestBody Map<String, Object> updates,
//            @PathVariable("id") String id) {
//
//        heavyResourceRepository.save(updates, id);
//        return ResponseEntity.ok("resource updated");
//    }

//    public void updateSongName(int id, String name) {
//        Optional<Song> songOptional = Optional.ofNullable(songDAO.getSongById(id));
//        if(songOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! " + id + " has not been found :( Please try again.");
//        }
//        songDAO.updateSongName(id, name);
//    }
//
//    public void updateSongGenre(int id, String genre) {
//        Optional<Song> songOptional = Optional.ofNullable(songDAO.getSongById(id));
//        if(songOptional.isEmpty()) {
//            throw new ResourceNotFound("Sorry! " + id + " has not been found :( Please try again.");
//        }
//        songDAO.updateSongGenre();
//    }
//
//    public void updateSongDuration(int id, int duration) {
//        songDAO.updateSongDuration();
//    }
//
//    public void updateSongReleaseDate(int id, LocalDate release_date) {
//        songDAO.updateSongReleaseDate(id, release_date);
//    }
//
//    public void updateSongLanguage(int id, String language) {
//        songDAO.updateSongLanguage();
//    }
//
//    public void updateSongArtistId(int id, int artist_id) {
//        songDAO.updateSongArtistId();
//    }
//
//    public void updateSongAlbumId(int id, String album_id) {
//        songDAO.updateSongAlbumId();
//    }
//
//    public void updateSongName(int id, String name) {
//        songDAO.updateSongName(id, name);
//    }
//
//    public void updateSongGenre(int id, String genre) {
//        songDAO.updateSongGenre();
//    }
//
//    public void updateSongDuration(int id, int duration) {
//        songDAO.updateSongDuration();
//    }
//
//    public void updateSongReleaseDate(int id, LocalDate release_date) {
//        songDAO.updateSongReleaseDate(id, release_date);
//    }
//
//    public void updateSongLanguage(int id, String language) {
//        songDAO.updateSongLanguage();
//    }
//
//    public void updateSongArtistId(int id, int artist_id) {
//        songDAO.updateSongArtistId();
//    }
//
//    public void updateSongAlbumId(int id, String album_id) {
//        songDAO.updateSongAlbumId();
//    }


    //DELETE
    public void deleteSong(int id) {
        if(DoesSongExist.check(id)) {
            songDAO.deleteSong(id);
        }
    }
}
