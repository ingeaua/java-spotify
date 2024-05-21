package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Playlist {

    private String playlistName;
    private String description;
    private List<Song> songs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(playlistName, playlist.playlistName) && Objects.equals(description, playlist.description) && Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistName, description, songs);
    }

    public Playlist()
    {
        this.playlistName = "";
        this.songs = new ArrayList<>();
        this.description = null;
    }
    public Playlist(String playlistName)
    {
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();
        this.description = null;
    }
    public Playlist(String playlistName,String description)
    {
        this.playlistName = playlistName;
        this.description = description;
        this.songs = new ArrayList<>();
    }
    public Playlist(Playlist p)
    {
        this.playlistName = p.playlistName;
        this.description = p.description;
        this.songs = new ArrayList<>(p.songs);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<Song> getSongs() {
        return songs;
    }
    public void removeSong(Song song)
    {
        this.songs.remove(song);
    }
    public void removeSongByName(String songName)
    {
        int ok=0;
        for(Song song: songs)
        {
            if (song.getTitle().equalsIgnoreCase(songName))
            {
                songs.remove(song);
                ok=1;
                break;
            }
        }
        if(ok==0)System.out.println("The song does not exist!");
    }
    public void setSongs(List<Song> songs) {
        this.songs =songs;
    }
    public void addSong(Song song)
    {
        this.songs.add(song);
    }



}
