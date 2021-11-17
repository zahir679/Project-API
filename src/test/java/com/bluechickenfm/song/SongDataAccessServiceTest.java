package com.bluechickenfm.song;


import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

                import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        void canGetSongsById() {
            // given

            Song firstSong = new Song(1, "My Luv", "K-pop", 180, 118, 118, LocalDate.of(2018,9,15),"Korean" , "Spotify");
            List<Song> songs = List.of(firstSong);

            // when
            when(songDAO.getSongById(1)).thenReturn(Optional.of(firstSong));
            Optional<Song> actual = Optional.ofNullable(underTest.getSongById(1));


            // then
            assertThat(actual).isEqualTo(Optional.of(firstSong));
        }

    @Test
    @DisplayName("Test to see if all songs can be got from the database")
    void canGetAllSongs() {
        // given



        // when



        // then

    }



}
