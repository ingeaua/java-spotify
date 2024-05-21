package repositories;

import models.Album;
import database.DatabaseConfiguration;
import models.Song;

import java.sql.*;
import java.util.Objects;

public class AlbumRepo {

    private static Connection connection = DatabaseConfiguration.getConnection();
    public AlbumRepo (){}

    public static void addAlbum(Album album) {
        try
        {
            String query = "INSERT INTO albums (title, genre, artist) " +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, album.getTitle());
            statement.setString(2, album.getGenre());
            statement.setString(3, album.getArtist());

            statement.executeUpdate();

            for (Song song : album.getSongs()) {
                SongRepo.addSong(song);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when adding Album!");
        }
    }

    public static void showAlbums() {
        try {
            String query = "SELECT * FROM albums";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet= statement.executeQuery();

            int albumCounter = 1;

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");
                if (!Objects.equals(title, "Single")) {
                    System.out.println("Album " + albumCounter + ": " + title + " by " + artist);
                    albumCounter += 1;
                }


            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when showing albums!");
        }

    }

    public static void deleteAlbum(String title) {
        try {
            String query = "DELETE FROM albums WHERE title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.executeUpdate();
            System.out.println("Album and it's songs were deleted!");
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when deleting album!");
        }

    }


}
