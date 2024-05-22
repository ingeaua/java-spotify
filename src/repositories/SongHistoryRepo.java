package repositories;

import models.Song;
import database.DatabaseConfiguration;
import models.SongHistory;

import java.sql.*;
import java.time.LocalDateTime;


public class SongHistoryRepo {
    private static Connection connection = DatabaseConfiguration.getConnection();

    public SongHistoryRepo() {}

    public static SongHistory getHistoryByUser(String userName) {

        try {
            String query = "SELECT * FROM history WHERE userName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();

            SongHistory history = new SongHistory();

            while (resultSet.next()) {

                LocalDateTime dateTime = resultSet.getTimestamp("timestamp").toLocalDateTime();
                String songTitle = resultSet.getNString("songTitle");
                Song song = SongRepo.getSongByTitle(songTitle);
                history.addSongToHistory(song, dateTime);

            }

            return history;

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when getting history by user!");
            return null;
        }
    }

    public static void addSongToHistory(String userName, String songTitle) {
        try
        {
            String query = "INSERT INTO history (userName, songTitle, timestamp) " +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, songTitle);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            statement.setTimestamp(3, timestamp);

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when adding song in history!");
        }
    }

}