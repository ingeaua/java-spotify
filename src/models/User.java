package models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private List<Playlist> playlists;
    private SongHistory history;
    private Deque<Song> queue;

    public User() {
        this.playlists = new ArrayList<>();
        this.queue = new ArrayDeque<>() {
        };
        this.history = new SongHistory();
    }

    // constructor
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.playlists = new ArrayList<>();
        this.queue = new ArrayDeque<>();
        this.history = new SongHistory();
    }
}
