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
//        musicdb = mock(List<Song>);

    }

    @Test
    @DisplayName("Test to see if songs can be got by id")
    void canGetSongsById() {
        // given

        Song firstSong = new Song(1, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018, 9, 15), "Korean", "Spotify");
        List<Song> songs = List.of(firstSong);

        // when
        when(songDAO.getSongById(1)).thenReturn(Optional.of(firstSong));
        Optional<Song> actual = underTest.getSongById(1);


        // then
        assertThat(actual).isEqualTo(Optional.of(firstSong));
    }




//    @Test
//    @DisplayName("Test to see if all songs can be got from the database")
//    void canGetAllSongs() {
//        // given
//
//        List<Song> musicdb = List<>
//
//
//        // when
//
//
//
//        when(songDAO.getAllSongs()).thenReturn();
//
//
//        // then
//
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
        int result = underTest.deleteSong(2);
        assertThat(result).isEqualTo(1);
        }
}
