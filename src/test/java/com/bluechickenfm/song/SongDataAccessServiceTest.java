package com.bluechickenfm.song;


import com.bluechickenfm.exception.Conflict;
import com.bluechickenfm.exception.ResourceNotFound;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    @DisplayName("Test to see if song is added")
    void addSong(){
        //given
        Song firstSong = new Song(1, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018, 9, 15), "Korean", "Spotify");

        //when
        String actual = underTest.addSong(firstSong);

        //then
        assertThat(actual).isEqualTo("Song added");

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


    @Test
    @DisplayName("Testing if the update method works correctly")
    void updateSongWhenIdIsRight() {
        // given
        Song song = new Song(
                1,
                "My Luv",
                "K-pop",
                180,
                118,
                118,
                LocalDate.of(2018, 9, 15),
                "Korean",
                "Spotify"
        );

        when(songDAO.getSongById(eq(1))).thenReturn(Optional.of(song));
        when(songDAO.updateSong(eq(1), eq(song))).thenReturn(1);

        // when
        String result = underTest.updateSong(1, song);

        verify(songDAO).updateSong(eq(1), eq(song));
        assertThat(result).isEqualTo("Song updated!");
    }


    @Test
    @DisplayName("Testing if the update method works incorrectly")
    void updateSongWhenIdIsWrong() {
        // given
        Song song = new Song(
                1,
                "My Luv",
                "K-pop",
                180,
                118,
                118,
                LocalDate.of(2018, 9, 15),
                "Korean",
                "Spotify"
        );

        when(songDAO.getSongById(eq(1))).thenReturn(Optional.of(song));
        when(songDAO.updateSong(eq(1), eq(song))).thenReturn(0);

        // when
        String result = underTest.updateSong(1, song);

        verify(songDAO).updateSong(eq(1), eq(song));
        assertThat(result).isEqualTo("Song not updated...");
    }

    @Test
    @DisplayName("Testing if the update method throw an exception")
    void updateSongThrowsException() {
        // given
        Song song = new Song(
                1,
                "My Luv",
                "K-pop",
                180,
                118,
                118,
                LocalDate.of(2018, 9, 15),
                "Korean",
                "Spotify"
        );

        when(songDAO.getSongById(eq(1))).thenReturn(Optional.empty());

        // when
        assertThatThrownBy(() -> underTest.updateSong(1, song))
                .isInstanceOf(ResourceNotFound.class)
                        .hasMessageContaining("Sorry! Song with id 1 has not been found :(");

        verify(songDAO, never()).updateSong(any(Integer.class), any(Song.class));
    }
//    @Test
//    @DisplayName("Testing if the update method throw an exception")
//    void updateSongThrowsConflict() {
//        // given
//        Song song = new Song(
//                1,
//                "My Luv",
//                "K-pop",
//                180,
//                118,
//                118,
//                LocalDate.of(2018, 9, 15),
//                "Korean",
//                "Spotify"
//        );
//
//        when(songDAO.getSongById(eq(1))).thenReturn(Optional.of(song));
//        when(songDAO.updateSong(eq(1), eq(song))).thenReturn(1);
//        when(songDAO.getSongByName(eq("My Luv"))).thenReturn();
//
//
//        // when
//        assertThatThrownBy(() -> underTest.updateSong(1, song))
//                .isInstanceOf(Conflict.class)
//                .hasMessageContaining("Unable to update song details - song already exists!");
//
//        verify(songDAO, never()).updateSong(any(Integer.class), any(Song.class));
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
