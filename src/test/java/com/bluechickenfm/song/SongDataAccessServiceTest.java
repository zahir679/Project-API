package com.bluechickenfm.song;


import org.assertj.core.api.AbstractBigDecimalAssert;
import org.flywaydb.core.internal.database.base.Connection;
import org.flywaydb.core.internal.database.base.Database;
import org.flywaydb.core.internal.database.base.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.nio.file.OpenOption;
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
    void getSongsById() {
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



//    @Test
//        void canGetPeopleFromDB() {
//            // given
//        Song firstSong = new Song(1, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018, 9, 15), "Korean", "Spotify");
//        List<Song> songs = List.of(firstSong);
//            // when
//            when(songDAO.getAllSongs()).thenReturn((List<Song>) firstSong);
//            // then
//            assertThat(underTest.getAllSongs()).isEqualTo(firstSong);
//        }


    @Test
    @DisplayName("Testing if the update method works correctly")
    void updateSong() {
        // given
        Song firstSong = new Song(2, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018, 9, 15), "Korean", "Spotify");
        Optional <Song> songs = Optional.of(firstSong);
        // when
        when(songDAO.updateSong(2, firstSong)).thenReturn(1);
        String updateResult = underTest.updateSong(2, firstSong);
        //then
        assertThat(updateResult).isEqualTo("Song updated!");



    }




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
