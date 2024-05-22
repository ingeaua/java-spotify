package models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.ArrayList;

// map of the format
// song : array of dates the song was listened to
public class SongHistory {

    private HashMap<Song, ArrayList<LocalDateTime>> history;

    public SongHistory() {
        history = new HashMap<>();
    }

    public SongHistory(SongHistory history) {
        this.history = new HashMap<>(history.history);
    }

    public void addSongToHistory(Song song, LocalDateTime timeDate) {
        if (history.containsKey(song)) {
            history.get(song).add(timeDate);
        } 
        else {
            ArrayList<LocalDateTime> dates = new ArrayList<>();
            dates.add(timeDate);
            history.put(song, dates);
        }
    }
}
