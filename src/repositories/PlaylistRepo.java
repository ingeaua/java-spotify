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

            }

            return playlists;


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when getting Playlists (by username)!");
            return null;
        }

    }

}
