package models;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Song {

    // attributes: id, title, genre, artist, duration, (album + albumId if the song is part of an album), set of features
    private static Integer songsCounter;
    private Integer songId;
    private String title;
    private String genre;
    private String artist;
    private Integer duration;
    private String album;
    private Integer albumId;
    private Set<String> features=new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) && Objects.equals(genre, song.genre) && Objects.equals(artist, song.artist) && Objects.equals(features, song.features) && Objects.equals(duration, song.duration) && Objects.equals(songId, song.songId) && Objects.equals(album, song.album) && Objects.equals(albumId, song.albumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, artist, features, duration, songId, album, albumId);
    }

    public Song() {
        this.title = "";
        this.genre = "";
        this.artist = "";
        this.duration = 0;
        this.album = "";
        this.albumId = -1;
        this.features = new HashSet<>();
    }

    public Song(String title, String genre, String artist, Integer duration, String album, Integer albumId, Set<String> features) {

        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
        this.album = album;
//        this.songId = songId;
        this.albumId=albumId;
        this.features= new HashSet<>(features);
    }

//    public Song(Song song) todo: nu ar trebui sa am nevoie de asta dar o sa vad mai tz
//    {
//        this.title = song.title;
//        this.genre = song.genre;
//        this.artist = song.artist;
//        this.duration = song.duration;
//        this.album = song.album;
//        this.songId=song.songId;
//        this.albumId=song.albumId;
//        this.features= new HashSet<>(song.features);
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

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Set<String> getFeatures() {
        return features;
    }

    public void setFeatures(Set<String> features) {
        this.features = new HashSet<String>(features);
    }
}
