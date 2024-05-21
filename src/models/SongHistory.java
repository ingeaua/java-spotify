package models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.ArrayList;

// map of the format
// song : array of dates the song was listened to
public class SongHistory {

    private HashMap<Song, ArrayList<LocalDateTime>> history;

    SongHistory() {
        history = new HashMap<>();
    }

}
