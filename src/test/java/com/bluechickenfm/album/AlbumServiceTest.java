package com.bluechickenfm.album;


import com.bluechickenfm.artist.Artist;
import com.bluechickenfm.exception.ResourceNotFound;
import com.bluechickenfm.song.Song;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class AlbumServiceTest {
    private AlbumDAO albumDAO;
    private AlbumService underTest;

    @BeforeEach
    void setUp() {
        albumDAO = mock(AlbumDAO.class);
        underTest = new AlbumService(albumDAO);
    }

    @Test
    @DisplayName("Test to see if Album is added correctly")
    void addAlbum(){
        //given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);

        //when
        String actual = underTest.addAlbum(firstAlbum);

        //then
        assertThat(actual).isEqualTo("Album added");
    }

    @Test
    @DisplayName("Test to see if an album can be got by id")
    void getAlbumById() {
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        // when
        when(albumDAO.getAlbumById(1)).thenReturn(List.of(firstAlbum));
        List<Album>actual = underTest.getAlbumById(1);
        // then
        assertThat(actual).isEqualTo(List.of(firstAlbum));
    }


    @Test
    @DisplayName("Test to see if album can be got by name")
    void getAlbumByName(){
        //given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
       List<Album> albums = List.of(firstAlbum);
        //when
        when(albumDAO.getAlbumByName("Views")).thenReturn(albums);
        List<Album> actual = underTest.getAlbumByName("Views");
        assertThat(actual).isEqualTo(List.of(firstAlbum));

    }

    @Test
    @DisplayName("Test to see if get album by name method throws exception when name is incorrect")
    void getAlbumByNameThrowsException(){
        //given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        List<Album> albums = List.of(firstAlbum);
        //when
        when(albumDAO.getAlbumByName(eq("Views"))).thenReturn(albums);

        // when
        assertThatThrownBy(() -> underTest.getAlbumByName("Viws"))
                .isInstanceOf(ResourceNotFound.class)
                .hasMessageContaining("Sorry! The album Viws has not been found :( Please try again.");

        verify(albumDAO, never()).updateAlbum(any(Integer.class), any(Album.class));
    }

    @Test
    @DisplayName("Test to see if all Albums can be got from the database at once")
    void getAllAlbums() {
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016, 4, 29), 20);
        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
                LocalDate.of(1976,10,11), 10);
        Album thirdAlbum = new Album(3, "Back In Black" , 3 , "Rock" ,
                LocalDate.of( 1980,07,25),10);
        Album fourthAlbum = new Album( 4, "25" , 4, "Soul",
                LocalDate.of(2015,11,20), 11);

        List<Album> AlbumTestDb = List.of(firstAlbum, secondAlbum, thirdAlbum, fourthAlbum);

        // when
        when(albumDAO.getAllAlbums()).thenReturn(AlbumTestDb);
        int resultSize = underTest.getAllAlbums().size();

        //then
        assertThat(resultSize).isEqualTo(4);
    }

    @Test
    @DisplayName("Testing if the update album method works correctly")
    void updateAlbumWhenIdIsRight() {
        // given
        Album testAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016, 4, 29), 20);

        when(albumDAO.getAlbumById(eq(1))).thenReturn(List.of(testAlbum));
        when(albumDAO.updateAlbum(eq(1), eq(testAlbum))).thenReturn(1);

        // when
        String albumResult = underTest.updateAlbum(1, testAlbum);

        verify(albumDAO).updateAlbum(eq(1), eq(testAlbum));
        assertThat(albumResult).isEqualTo("Album updated!");
    }

    @Test
    @DisplayName("Test to see if a album can be deleted")
    void deleteAlbum() {
        //given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016, 4, 29), 20);
        // when
        when(albumDAO.deleteAlbum(1)).thenReturn(1);
        // then
        String result = underTest.deleteAlbum(1);
        assertThat(result).isEqualTo("Album deleted!");
    }



    @Test
    @DisplayName("Testing the get album by album id method")
    void getAlbumByArtist(){
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
                LocalDate.of(1976,10,11), 10);
        List<Album> albums = List.of(firstAlbum, secondAlbum);
        //when
        when(albumDAO.getAlbumsByArtist(1)).thenReturn(List.of(firstAlbum));
        List<Album> actual = underTest.getAlbumsByArtist(1);
        assertThat(actual).isEqualTo(List.of(firstAlbum));
    }
    @Test
    @DisplayName("test to see if get album by artist ID method throws exception when album ID is incorrect")
    void getAlbumByArtistThrowsException() {
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
                LocalDate.of(1976,10,11), 10);
        List<Album> albums = List.of(firstAlbum, secondAlbum);

        when(albumDAO.getAlbumsByArtist(1)).thenReturn(List.of(firstAlbum,secondAlbum));

        // when
        assertThatThrownBy(() -> underTest.getAlbumsByArtist(3))
                .isInstanceOf(ResourceNotFound.class)
                .hasMessageContaining("Sorry! An album by artist " + 3 +" has not been found :( Please try again.");

        verify(albumDAO, never()).getAlbumsByArtist(1);
    }

    @Test
    @DisplayName("Testing the get album by album name method")
    void getAlbumByArtistName(){
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
                LocalDate.of(1976,10,11), 10);
        List<Album> albums = List.of(firstAlbum, secondAlbum);
        //when
        when(albumDAO.getAlbumsByArtistName("Drake")).thenReturn(List.of(firstAlbum));
        List<Album> actual = underTest.getAlbumsByArtistName("Drake");
        assertThat(actual).isEqualTo(List.of(firstAlbum));

    }


    @Test
    @DisplayName("Testing the get album by genre method")
    void getAlbumByGenre(){
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
                LocalDate.of(1976,10,11), 10);
        List<Album> albums = List.of(firstAlbum, secondAlbum);
        //when
        when(albumDAO.getAlbumsByGenre("Pop")).thenReturn(List.of(secondAlbum));
        List<Album> actual = underTest.getAlbumsByGenre("Pop");
        assertThat(actual).isEqualTo(List.of(secondAlbum));

    }

    @Test
    @DisplayName("Testing the get album by year method")
    void getAlbumByYear(){
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
                LocalDate.of(1976,10,11), 10);
        List<Album> albums = List.of(firstAlbum, secondAlbum);
        //when
        when(albumDAO.getAlbumsByYear(LocalDate.of(2016,1,1), LocalDate.of(2016,12,31))).thenReturn(List.of(firstAlbum));
        List<Album> actual = underTest.getAlbumsByYear(2016);
        assertThat(actual).isEqualTo(List.of(firstAlbum));

    }

    @Test
    @DisplayName("Testing the get album by Decade method")
    void getAlbumByDecade(){
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
                LocalDate.of(1976,10,11), 10);
        List<Album> albums = List.of(firstAlbum, secondAlbum);
        //when
        when(albumDAO.getAlbumsByDecade(LocalDate.of(1970,1,1), LocalDate.of(1979,12,31))).thenReturn(List.of(secondAlbum));
        List<Album> actual = underTest.getAlbumsByDecade(1970);
        assertThat(actual).isEqualTo(List.of(secondAlbum));

    }


//    @Test
//    @DisplayName("Testing joint queries getting album by Decade method")
//    void getAlbumByGenreAndDecade(){
//        // given
//        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
//                LocalDate.of(2016,4,29), 20);
//        Album secondAlbum = new Album(2, "Arrival", 2, "Pop" ,
//                LocalDate.of(1976,10,11), 10);
//        List<Album> albums = List.of(firstAlbum, secondAlbum);
//        //when
//        when(albumDAO.getAlbumsByGenreAndDecade(LocalDate.of(1970,1,1), LocalDate.of(1979,12,31))).thenReturn(List.of(secondAlbum));
//        List<Album> actual = underTest.getAlbumsByDecade(1970);
//        assertThat(actual).isEqualTo(List.of(secondAlbum));
//
//    }




}

