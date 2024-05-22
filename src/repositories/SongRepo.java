package repositories;

import models.Playlist;
import models.Song;
import database.DatabaseConfiguration;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepo {
    private static Connection connection = DatabaseConfiguration.getConnection();
    public SongRepo (){}
    public static void addSong(Song song) {
        try
        {
            String query = "INSERT INTO songs (title, genre, artist, duration, albumTitle) " +
                    "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getGenre());
            statement.setString(3, song.getArtist());
            statement.setInt(4, song.getDuration());
            statement.setString(5, song.getAlbum());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when adding Song!");
        }
    }

    public static void showSongs() {
        try {
            String query = "SELECT * FROM songs";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet= statement.executeQuery();

            int songCounter = 1;

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");

                System.out.println("Song " + songCounter + ": " + title + " by " + artist);
                songCounter += 1;

            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when showing songs!");
        }

    }

    public static void deleteSong(String title) {
        try {
            String query = "DELETE FROM songs WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.executeUpdate();
            System.out.println("Song was deleted!");
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when deleting song!");
        }

    }

    public static Song getSongByTitle(String title) {
        try {
            String query = "SELECT * FROM songs WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            ResultSet resultSet= statement.executeQuery();

            if (resultSet.next()) {
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                String album = resultSet.getString("albumTitle");
                Integer duration = resultSet.getInt("duration");

                return new Song(title, genre, artist, duration, album);
            }

            return null;

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when getting song by title!");
            return null;
        }
    }

    public static List<Song> getSongsByPlaylist(String playlistName) {

        try
        {
            String query = "SELECT * FROM songs_playlists WHERE playlistName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, playlistName);
            ResultSet resultSet = statement.executeQuery();

            List<Song> songs = new ArrayList<>();

            while (resultSet.next()) {
                String songName = resultSet.getString("songName");

                Song song = getSongByTitle(songName);
                songs.add(song);

            }

            return songs;


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when getting Songs (by playlistName)!");
            return null;
        }

    }



}
