package com.bluechickenfm.song;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SongDataAccessServiceTest {


    private SongDAO songDAO;
    private SongService underTest;

    @BeforeEach
    void setUp() {
        songDAO = mock(SongDAO.class);
        underTest = new SongService(songDAO);


    }

    @Test
    @DisplayName("Test to see if songs can be got by id")
    void getSongById() {
        // given

        Song firstSong = new Song(1, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018, 9, 15), "Korean", "Spotify");
        List<Song> songs = List.of(firstSong);

        // when
        when(songDAO.getSongById(1)).thenReturn(Optional.of(firstSong));
        Optional<Song> actual = underTest.getSongById(1);


        // then
        assertThat(actual).isEqualTo(Optional.of(firstSong));
    }

    @Test
    @DisplayName("Test to get song by name")
    void getSongByName(){
        //given
        Song firstSong = new Song(1, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018, 9, 15), "Korean", "Spotify");
        List<Song> songs = List.of(firstSong);
        //when
        when(songDAO.getSongByName("My Luv")).thenReturn(songs);
        List<Song> actual = underTest.getSongByName("My Luv");
        assertThat(actual).isEqualTo(List.of(firstSong));

    }



    @Test
    @DisplayName("Test to see if all songs can be got from the database")
    void getAllSongs() {
        // given


        Song firstSong = new Song(1, "My Luv", "K-pop", 180, 118, 118,
                LocalDate.of(2018, 9, 15), "Korean", "Spotify");
        Song secondSong= new Song(2, "Ideal" , "K-pop", 210, 118 ,  118,
                LocalDate.of(2018,10,15), "Korean", "Spotify");
        Song thirdSong = new Song(4, "Juicy" , "Rap", 180, 75, 75,
                LocalDate.of(1994,8,9), "English", "Spotify");

        List<Song> musicDb = List.of(firstSong, secondSong, thirdSong);

        // when
        when(songDAO.getAllSongs()).thenReturn(musicDb);
        int actual = underTest.getAllSongs().size();
        // then
        assertThat(actual).isEqualTo(3);

    }

//
//    @Test
//    @DisplayName("Testing if the update method works correctly")
//    void updateSong() {
//        // given
//        Song firstSong = new Song(2, "My Luv", "K-pop", 180, 118, 118,
//                LocalDate.of(2018, 9, 15), "Korean", "Spotify");
//        Song updatedFirstSong = new Song(2, "My Luv remix", "K-pop", 180, 118, 118,
//                LocalDate.of(2018, 9, 15), "Korean", "Spotify");
//        underTest.addSong(firstSong);
//        underTest.updateSong(2, updatedFirstSong);
//        Optional<Song> updated = underTest.getSongById(2);
//        assertThat(updated).isPresent().hasValueSatisfying(v -> {
//            assertThat(updated).isEqualTo(updatedFirstSong);
//        });
//    }
//

        // when
//        Update song
//        fetch updated song
//        compare the values of the song

//        if(songDAO.updateSong(2, firstSong) == 1) {
//            String updateResult = underTest.updateSong(2, updatedFirstSong);
//            //then
//            assertThat(updateResult).isEqualTo("Song updated!");
//        }

//    }




    @Test
    @DisplayName("Test to see if a song can be deleted")
    void deleteSong() {
        //given
        Song firstSong = new Song(2, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018, 9, 15), "Korean", "Spotify");
        List<Song> songs = List.of(firstSong);
        // when
        when(songDAO.deleteSong(2)).thenReturn(1);
        // then
        String result = underTest.deleteSong(2);
        assertThat(result).isEqualTo("Song deleted.");
        }
}
