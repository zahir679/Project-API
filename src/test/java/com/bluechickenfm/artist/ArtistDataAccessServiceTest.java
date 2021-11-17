package com.bluechickenfm.artist;


import com.bluechickenfm.exception.ResourceNotFound;
import com.bluechickenfm.song.Song;
import com.bluechickenfm.song.SongDAO;
import com.bluechickenfm.song.SongService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

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
    void addArtist(){
        //given
        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");
        //when
        String actual = underTest.addArtist(firstArtist);

        //then
        assertThat(actual).isEqualTo("Artist added");

    }

    @Test
    @DisplayName("Testing if the update method works correctly for artist")
    void updateArtist() {
        // given
        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");

        when(artistDAO.getArtistById(eq(1))).thenReturn(List.of(firstArtist));
        when(artistDAO.updateArtist(eq(1), eq(firstArtist))).thenReturn(1);

        // when
        String result = underTest.updateArtist(1, firstArtist);

        verify(artistDAO).updateArtist(eq(1), eq(firstArtist));
        assertThat(result).isEqualTo("Artist updated");
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
    @DisplayName("Test to get artist by name")
    void getArtistByName(){
        //given
        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");
        Artist secondArtist = new Artist(2, "FKJ", "French", "Ylang Ylang");
        List<Artist> artists = List.of(firstArtist, secondArtist);
        //when
        when(artistDAO.getArtistByName("Drake")).thenReturn(List.of(firstArtist));
        List<Artist> actual = underTest.getArtistByName("Drake");
        assertThat(actual).isEqualTo(List.of(firstArtist));

    }

    @Test
    @DisplayName("Test to get artist by nationality")
    void getArtistByNationality(){
        //given
        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");
        Artist secondArtist = new Artist(2, "FKJ", "French", "Ylang Ylang");
        List<Artist> artists = List.of(firstArtist, secondArtist);
        //when
        when(artistDAO.getArtistByNationality("Canadian")).thenReturn(List.of(firstArtist));
        List<Artist> actual = underTest.getArtistsByNationality("Canadian");
        assertThat(actual).isEqualTo(List.of(firstArtist));
    }

    @Test
    @DisplayName("test to see if get artist by name method throws exception when name is incorrect")
    void getArtistByNameThrowsException() {
        // given
        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");
        Artist secondArtist = new Artist(2, "FKJ", "French", "Ylang Ylang");
        List<Artist> artists = List.of(firstArtist, secondArtist);

        when(artistDAO.getArtistByName("Drake")).thenReturn(List.of(firstArtist));

        // when
        assertThatThrownBy(() -> underTest.getArtistByName("BTS"))
                .isInstanceOf(ResourceNotFound.class)
                .hasMessageContaining("Sorry! The artist BTS has not been found :( Please try again.");

        verify(artistDAO, never()).getArtistByName(firstArtist.toString());
    }


    @Test
    @DisplayName("test to see if get artist by biggest hit works")
    void getArtistByBiggestHit(){
        Artist firstArtist = new Artist(1, "Drake", "Canadian", "One Dance");
        Artist secondArtist = new Artist(2, "FKJ", "French", "Ylang Ylang");
        List<Artist> artists = List.of(firstArtist, secondArtist);

        when(artistDAO.getArtistByBiggestHit("One Dance")).thenReturn(List.of(firstArtist));
        List<Artist> actual = underTest.getArtistByBiggestHit("One Dance");
        assertThat(actual).isEqualTo(List.of(firstArtist));


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
        assertThat(result).isEqualTo("Artist deleted");
    }

}
