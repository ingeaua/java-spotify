package models;

import java.util.Objects;

public class Song {


    // attributes: title, genre, artist, duration, (album if the song is part of an album)
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

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }


}
