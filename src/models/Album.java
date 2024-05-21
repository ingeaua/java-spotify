package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Album
{
    private static Integer albumsCounter ;
    private Integer albumId;
    private String title;
    private String artist;
    private String genre;
    private List<Song> songs;
    private String releaseDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(title, album.title) && Objects.equals(artist, album.artist) && Objects.equals(genre, album.genre) && Objects.equals(songs, album.songs) && Objects.equals(releaseDate, album.releaseDate) && Objects.equals(albumId, album.albumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, genre, songs, releaseDate, albumId);
    }

    public Album()
    {
        this.title = "";
        this.artist = "";
        this.songs = new ArrayList<>();
        this.releaseDate = "";
        this.genre = " ";
    }
    public Album(String title, String artist, String releaseDate,String genre,Integer albumID) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.albumId = albumID;
    }
    public Album(String title, String artist, List<Song> songs, String releaseDate,String genre)
    {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>(songs);
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Integer getAlbumID() {
        return albumId;
    }

    public void setAlbumID(Integer albumID) {
        this.albumId = albumID;
    }

    public static Integer getNumAlbumsAdded() {
//        todo: aici tre sa imi numere cate is in bd
        return albumsCounter;
    }

    public static void setNumAlbumsAdded(Integer numAlbumsAdded) {
        Album.albumsCounter = numAlbumsAdded;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongs(List<Song> songs) {

        this.songs = new ArrayList<>(songs);
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<Song> getSongs() {
        return songs;
    }

}