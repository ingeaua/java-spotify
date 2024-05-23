# Music Management System - Spotify

## Project Overview
This project implements a music management system that allows users to manage albums, playlists, podcasts, release radars, songs, and song histories. It includes functionalities for user management and auditing actions within the system.

## Class Structure

### Database
- **DatabaseConfiguration**: Implements methods for connecting and disconnecting from the MySQL database.

### Models
- **Album**: Represents an album with details like title, artist, genre, etc.
- **Playlist**: Represents a playlist which can contain multiple songs.
- **Podcast**: Represents a podcast with details like title, host, duration, etc.
- **ReleaseRadar**: Represents a list of newly released songs or albums.
- **Song**: Represents a song with details like title, artist, duration, etc.
- **SongHistory**: Represents the history of songs played by users.
- **User**: Represents a user with details like username, email, password, etc.

### Repositories
Repositories manage database operations for their respective models.
- **AlbumRepo**: Handles CRUD operations for albums.
- **PlaylistRepo**: Handles CRUD operations for playlists.
- **PodcastRepo**: Handles CRUD operations for podcasts.
- **SongHistoryRepo**: Handles CRUD operations for song histories.
- **SongRepo**: Handles CRUD operations for songs.
- **UserRepo**: Handles CRUD operations for users.

### Services
Services contain the business logic and interact with repositories and models.
- **AuditService**: Implements logging actions to a CSV file during an application session (Singleton design pattern).
- **Main**: Instantiates the menu and runs the main application.
- **Menu**: Implements the interactive menu and instantiates a service object (Singleton design pattern).
- **ReadService**: Implements methods for reading data from the keyboard to create new objects.

## Running the Project

1. **Setup Database**: Ensure MySQL is installed and a database is created.
2. **Database Configuration**: Update the `DatabaseConfiguration` class with your database credentials.
3. **Tables creation**: Run the SQL queries in `table_creator` on your schema.
4. **Build and Run**: Compile and run the `Main` class to start the application.

## Login / register menu

```
Hello, welcome to the app!
1. Log in
2. Register
0. Exit app
```

## Main menu

```
----------- General options -----------
Hello, choose an option!
1. Add a song
2. Add an album
3. Add a podcast
4. Show all songs
5. Show all albums
6. Show all podcasts
7. Show all users
8. Show all playlists
9. Delete a song
10. Delete an album
11. Delete a podcast
------------- User options -------------
----- Add to queue -----
12. Add a song in front queue
13. Add a song in back queue
14. Add an album in queue
15. Add a playlist in queue
16. Add a random song in queue
----- Queue options -----
17. Listen songs from queue
18. Clear queue
19. Show queue
----- Playlist options -----
20. Create a playlist
21. Add a song to a playlist
22. Show your playlists
23. Delete a playlist
----- Release Radar -----
24. Show release radar
----- Show info -----
25. Show most listened song
26. Show total time listened today
27. Delete account

0. Exit app
```

## License
This project is licensed under the MIT License.
