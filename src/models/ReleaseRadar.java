package models;

// last 15 released song will be added to releaseradar

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
            this.getSongs().add(song);
            songsCounter++;
        }
        else
        {
            this.getSongs().remove(0);
            this.getSongs().add(song);
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