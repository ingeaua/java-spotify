package repositories;

import models.Podcast;
import database.DatabaseConfiguration;
import java.sql.*;
import java.util.Objects;

public class PodcastRepo {
    private static Connection connection = DatabaseConfiguration.getConnection();
    public PodcastRepo (){}
    public static void addPodcast(Podcast podcast) {
        try
        {
            String query = "INSERT INTO podcasts (name, creator, duration, topic) " +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, podcast.getPodcastName());
            statement.setString(2, podcast.getCreator());
            statement.setInt(3, podcast.getDuration());
            statement.setString(4, podcast.getTopic());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when adding Podcast!");
        }
    }

    public static void showPodcasts() {
        try {
            String query = "SELECT * FROM podcasts";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet= statement.executeQuery();

            int podcastCounter = 1;

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String creator = resultSet.getString("creator");
                System.out.println("Album " + podcastCounter + ": " + name + " by " + creator);
                podcastCounter += 1;


            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when showing podcasts!");
        }

    }

    public static void deletePodcast(String name) {
        try {
            String query = "DELETE FROM podcasts WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Podcast was deleted!");
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when deleting podcast!");
        }

    }


}
