[comment]: <> ( https://www.markdownguide.org/basic-syntax/#reference-style-links)

[![Contributors][contributors-shield]][contributors-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/zahir679/Project-API">
    <img src="./images/blueChickenFM_logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Blue Chicken FM</h3>

  <p align="center">
    A music library API and music database created using Java, Spring Boot and SQL for the BNTA back-end API group project.
    <br />
    <a href="https://github.com/zahir679/Project-API"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/zahir679/Project-API/issues">Report Bug</a>
    ·
    <a href="https://github.com/zahir679/Project-API/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://example.com)

Here's a blank template to get started: To avoid retyping too much info. Do a search and replace with your text editor for the following: `github_username`, `repo_name`, `twitter_handle`, `linkedin_username`, `email`, `email_client`, `project_title`, `project_description`

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [Java](https://www.java.com/en/)
* [PostgreSQL](https://www.postgresql.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Flyway](https://flywaydb.org/)
* [HikariCP](https://github.com/brettwooldridge/HikariCP)
* [JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy of this project up and running follow these simple steps.

### Prerequisites


* Open Postgres , create a local repository called 'chicken' and connect to it
  ```sh
  CREATE DATABASE chicken;
  \c chicken
  ```

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/zahir679/Project-API.git
   ```
2. Open Postgres , create a local repository called 'chicken' and connect to it
    ```sh
   CREATE DATABASE chicken;
   \c chicken
   ```

3. Open IntelliJ, go to the ProjectApiApplication class and click Run (green triangle button)
4. Check the Run log at the bottom of the screen. If the program is running, the last two lines of the log should display:
   ‘Tomcat started on port(s): 8080 (http) with context path '' ‘
   ‘Started ProjectApiApplication in x seconds’.
   The local ‘chicken’ database should also contain the populated ‘songs’, ‘artists’, and ‘albums’ tables.
5. To send requests, use an HTTP API client extension/platform such as Thunder Client or Postman.
6. See 'HTTP Requests' section for HTTP requests and their respective paths


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

The following table describes all the paths for the HTTP requests and their respective functionalities. 

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

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Your Name - Blue Chicken FM

Project Link: [https://github.com/zahir679/Project-API](https://github.com/zahir679/Project-API)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Zahir](https://github.com/zahir679)
* [Helena](https://github.com/helboi4)
* [Rashid](https://github.com/Rashid-F-Walcott)
* [Kun (Queenie)](https://github.com/imcalled)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png