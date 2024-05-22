package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Playlist {

    private String playlistName;
    private String description;
    private List<Song> songs;
    private String userName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(playlistName, playlist.playlistName) &&  Objects.equals(userName, playlist.userName) && Objects.equals(description, playlist.description) && Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistName, description, songs, userName);
    }

    public Playlist()
    {
        this.playlistName = "";
        this.songs = new ArrayList<>();
        this.description = null;
        this.userName = null;
    }
    public Playlist(String playlistName)
    {
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();
        this.description = null;
        this.userName = null;
    }
    public Playlist(String playlistName,String description)
    {
        this.playlistName = playlistName;
        this.description = description;
        this.songs = new ArrayList<>();
        this.userName = null;
    }
    public Playlist(String playlistName, String description, List<Song> songs) {
        this.playlistName = playlistName;
        this.description = description;
        this.songs = songs;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
