package repositories;

import database.DatabaseConfiguration;
import models.Playlist;
import models.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepo {

    private static Connection connection = DatabaseConfiguration.getConnection();
    public PlaylistRepo (){}
    public static void addPlaylist(Playlist playlist) {
        try
        {
            String query = "INSERT INTO playlists (name, description, userName) " +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, playlist.getPlaylistName());
            statement.setString(2, playlist.getDescription());
            statement.setString(3, playlist.getUserName());


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when adding Playlist!");
        }
    }

    public static List<Playlist> getPlaylistsByUser(String username) {

        try
        {
            String query = "SELECT * FROM playlists WHERE userName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            List<Playlist> playlists = new ArrayList<>();

            while (resultSet.next()) {
                String playlistName = resultSet.getString("name");
                String description = resultSet.getString("description");

                List<Song> songs = SongRepo.getSongsByPlaylist(playlistName);

                Playlist playlist = new Playlist(playlistName, description, songs);

                playlists.add(playlist);

            }

            return playlists;


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when getting Playlists (by username)!");
            return null;
        }

    }

    public static void showPlaylists() {

        try
        {
            String query = "SELECT * FROM playlists ";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int playlistCounter = 1;

            while (resultSet.next()) {
                String playlistName = resultSet.getString("name");
                String userName = resultSet.getString("userName");

                List<Song> songs = SongRepo.getSongsByPlaylist(playlistName);

                System.out.println("Playlist " + playlistCounter + ": " + playlistName + " by " + userName + ":");
                int songCounter = 1;
                for (Song song : songs) {
                    System.out.println("Song " + songCounter + ": " + song.getTitle() + " by " + song.getArtist());
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when showing Playlists!");
        }

    }

    public static void deletePlaylist(String playlistName) {
        try {
            String query = "DELETE FROM playlists WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, playlistName);
            statement.executeUpdate();
            System.out.println("Playlist was deleted!");
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when deleting playlist!");
        }
    }

    public static void addSongToPlaylist(String songName, String playlistName) {

        try
        {
            String query = "INSERT INTO songs_playlist (songName, playlistName) " +
                    "VALUES (?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, songName);
            statement.setString(2, playlistName);
            statement.executeUpdate();
            System.out.println("Song " + songName + " added to playlist " + playlistName + "!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when adding song to playlist!");
        }

    }

}
