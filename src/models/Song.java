package models;

import java.util.Objects;
import java.util.Set;

public class Song {

    // attributes: title, genre, artist, duration, (album if the song is part of an album)
    private static Integer songsCounter;
    private String title;
    private String genre;
    private String artist;
    private Integer duration;
    private String album;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(genre, song.genre) && Objects.equals(artist, song.artist) && Objects.equals(duration, song.duration) && Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, artist, duration, album);
    }

    public Song() {
        this.title = "";
        this.genre = "";
        this.artist = "";
        this.duration = 0;
        this.album = "Single";
    }

    public Song(String title, String genre, String artist, Integer duration) {

        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
        this.album = "Single";
    }

    public Song(String title, String genre, String artist, Integer duration, String album) {

        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
        this.album = album;
    }

//    public Song(Song song) todo: nu ar trebui sa am nevoie de asta dar o sa vad mai tz
//    {
//        this.title = song.title;
//        this.genre = song.genre;
//        this.artist = song.artist;
//        this.duration = song.duration;
//        this.album = song.album;
//    }

    public static Integer getSongsCount() {
//        TODO: aici trebuie calculat din numarul de melodii din baza de date
        return songsCounter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }



}
