package com.bluechickenfm.artist;


import com.bluechickenfm.song.Song;
import com.bluechickenfm.song.SongDAO;
import com.bluechickenfm.song.SongService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArtistDataAccessServiceTest {

    private ArtistDAO artistDAO;
    private ArtistService underTest;

    @BeforeEach
    void setUp() {
        artistDAO = mock(ArtistDAO.class);
        underTest = new ArtistService(artistDAO);
    }
    @Test
    @DisplayName("Test to see if artist is added")
    void addSong(){
        //given
        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");
        //when
        String actual = underTest.addArtist(firstArtist);

        //then
        assertThat(actual).isEqualTo("Artist added");

    }
        @Test
        @DisplayName("Test to see if artist can be got by id")
        void canGetArtistsById() {
            // given

            Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");

            // when
            when(artistDAO.getArtistById(1)).thenReturn(List.of(firstArtist));
            List<Artist>actual = underTest.getArtistById(1);


            // then
            assertThat(actual).isEqualTo(List.of(firstArtist));
        }


    @Test
    @DisplayName("Test to see if all artists can be got from the database")
    void canGetAllArtists() {
        // given


        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");
        Artist secondArtist = new Artist(2, "FKJ", "French", "Ylang Ylang");
        Artist thirdArtist = new Artist(3, "Michael Jackson", "American", "Billie Jean");


        List<Artist> artistDb = List.of(firstArtist, secondArtist, thirdArtist);

        // when

        when(artistDAO.getAllArtists()).thenReturn(artistDb);
        int actual = underTest.getAllArtists().size();
        // then
        assertThat(actual).isEqualTo(3);

    }

    @Test
    @DisplayName("Test to see if an artist can be deleted")
    void deleteArtist() {
        //given
        Artist firstArtist = new Artist(2, "Drake", "Canadian", "One Dance");
        List<Artist> artists = List.of(firstArtist);
        // when
        when(artistDAO.deleteArtist(2)).thenReturn(1);
        // then
        String result = underTest.deleteArtist(2);
        assertThat(result).isEqualTo("Artist deleted.");
    }

}
