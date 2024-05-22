package models;

import java.time.LocalDateTime;
import java.util.*;

import repositories.SongHistoryRepo;
import repositories.SongRepo;

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

    public User(String username, String password, String email, List<Playlist> playlists, SongHistory history) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.playlists = new ArrayList<>(playlists);
        this.queue = new ArrayDeque<>();
        this.history = new SongHistory(history);
    }

    public Playlist getPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (Objects.equals(playlist.getPlaylistName(), playlistName)) {
                return playlist;
            }
        }
        return null;
    }

    public void addSongToQueueFront(Song song) { queue.addFirst(song); }

    public void addSongToQueueBack(Song song) {
        queue.addLast(song);
    }

    public void addSongListToQueue(List<Song> songList) { queue.addAll(songList); }

    public void clearQueue() {queue.clear();}

    public void showQueue() {

        int songCountQueue = 1;

        for (Song song : queue) {
            System.out.println("Song " + songCountQueue + ": " + song.getTitle() + " by " + song.getArtist()
                                + " " + SongRepo.formatDuration(song.getDuration()));
            songCountQueue += 1;
        }
    }

    // todo here I have an exception if the same song is in the queue 2 times because the entry in database is duplicated
    public void listenToQueue() {
        for (Song song : queue) {
            history.addSongToHistory(song, LocalDateTime.now());
            SongHistoryRepo.addSongToHistory(username, song.getTitle());
        }
        queue.clear();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void showMostListenedSong() {
       history.showTopSong();
    }
}
