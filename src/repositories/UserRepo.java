package repositories;

import database.DatabaseConfiguration;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Objects;

public class UserRepo {

    private static Connection connection = DatabaseConfiguration.getConnection();
    public UserRepo (){}

    public static void addUser(User user) {
        try
        {
            String query = "INSERT INTO users (username, password, email) " +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when adding User!");
        }
    }

    public static User logIn(String email, String password) {
        try {
            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            // if data in cursor & correct password login else null
            if (resultSet.next() && Objects.equals(password, resultSet.getString("password"))) {

                String username = resultSet.getString("username");

                List<Playlist> playlists = PlaylistRepo.getPlaylistsByUser(username);

                SongHistory history = SongHistoryRepo.getHistoryByUser(username);

                return new User(username, password, email, playlists, history);
            }
            else {
                return null;
            }

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when logging in!");
            return null;
        }


    }

    public static void showUsers() {
        try {
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet= statement.executeQuery();

            int userCounter = 1;

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                System.out.println("User " + userCounter + ":\nemail: " + email + " \npassword: " + password);
                userCounter += 1;

            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when showing users!");
        }

    }

    public static void deleteUser(String userName) {
        try {
            String query = "DELETE FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            statement.executeUpdate();
            System.out.println("Your account was deleted!");
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error when deleting user!");
        }
    }
}
