HTTP Request Path | Request Type | Description |
| :--- | --- | :---
| http://localhost:8080/api/v1 | GET |Base path (...) - same for all the following requests |
| .../songs | GET | Get all songs |
| .../songs/{id} | GET | Get a single song by song id
|  | PUT | Update a song by id
|  | DELETE | Delete a song by id
| .../songs/name/{name} | GET | Get song by song name
| .../songs/artist/{artist_id} | GET | Get songs by artist id
| .../songs/artist_name/{artists_name} | GET | Get song by artist name
| .../songs/album/{album_id} | GET | Get songs by album id
| .../songs/album_name/{album_name} | GET | Get songs by album name
| .../songs/genre/{genre} | GET | Get songs by genre
| .../songs/year/{release_year} | GET | Get songs by release year
| .../songs/decade/{release_decade} | GET | Get songs by release decade
| .../songs/genre_decade/{genre}/{release_decade} | GET | Get songs by genre and decade
| .../songs/add | POST | Add a new song
|||
| .../artists | GET | Get all artists
| .../artists/{id} | GET | Get a single artist by id
| | PUT | Update an album
| | DELETE | Delete an album
| .../artists/name/{name} | GET | Get artists by name
| .../artists/nationality/{nationality} | GET | Get artists by nationality
| .../artists//biggest_hit/{biggest_hit} | GET | Get artists by biggest hit
| .../artists/add | POST | Add an artist
|||
| .../albums| GET | Get all albums
| .../albums/{id} | GET | Get album by id
|| PUT | Update an album
|| DELETE | Delete an album
| .../albums/name/{name} | GET | Get albums by name
| .../albums/artist/{artist_id} | GET | Get artist by artist id
| .../albums/artist_name/{artist_name} | GET | Get albums by artist name
| .../albums/genre/{genre} | GET | Get albums by genre
| .../albums/year/{release_year} | GET | Get albums by release year
| .../albums/decade/{release_decade} | GET | Get albums by release decade
| .../albums/genre_decade/{genre}/{release_decade} | GET | Get albums by genre and decade
| .../albums/add | POST | Add an album
