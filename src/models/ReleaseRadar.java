package models;

// last 15 released song will be added to releaseradar

import java.util.List;

public class ReleaseRadar extends Playlist
{
    private static int songsCounter;
    public ReleaseRadar()
    {
        super("Release Radar");
    }
    @Override
    public void addSong(Song song) {
        if (songsCounter < 15) {
            this.getSongs().add(0, song);
            songsCounter++;
        }
        else
        {
            this.getSongs().remove(0);
            this.getSongs().add(0, song);
        }
    }

    public void update(List<Song> songList) {
        for (Song song : songList) {
            addSong(song);
        }
    }

    public void show() {
        for (Song song : songs) {
            System.out.println("Song : " + song.getTitle() + " by " + song.getArtist());
        }
    }



    public static int getNumberSongsAdded() {
        return songsCounter;
    }

    public static int getNumSongsAdded() {
        return songsCounter;
    }

    public static void setNumSongsAdded(int numSongsAdded) {
        ReleaseRadar.songsCounter = numSongsAdded;
    }
}