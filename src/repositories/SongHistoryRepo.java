package repositories;

import models.Playlist;
import models.Song;
import database.DatabaseConfiguration;
import models.SongHistory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

}