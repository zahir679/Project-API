package com.bluechickenfm.album;


import com.bluechickenfm.artist.Artist;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class albumDataAccessServiceTest {
    private AlbumDAO albumDAO;
    private AlbumService underTest;

    @BeforeEach
    void setUp() {
        albumDAO = mock(AlbumDAO.class);
        underTest = new AlbumService(albumDAO);
    }
    @Test
    @DisplayName("Test to see if artist can be got by id")
    void canGetAlbumsById() {
        // given
        Album firstAlbum = new Album(1, "Views", 1, "Hip-Hop",
                LocalDate.of(2016,4,29), 20);
        // when
        when(albumDAO.getAlbumById(1)).thenReturn(List.of(firstAlbum));
        List<Album>actual = underTest.getAlbumById(1);
        // then
        assertThat(actual).isEqualTo(List.of(firstAlbum));
    }
}
