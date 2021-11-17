package com.bluechickenfm.song;

@Mapper Mapper(componentModel = "spring")
public interface SongMapper {
        void updateSongFromDto(SongDto dto, @MappingTarget Customer entity);
}
