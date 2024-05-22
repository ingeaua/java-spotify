package services;

import models.*;
import repositories.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private static Menu instance;
    private User loggedInUser;
    private ReleaseRadar releaseRadar;
    private Menu(User user) {loggedInUser = user;}

    AuditService auditService = AuditService.getInstance();

    private void showGeneralOptions() {

        System.out.println("----------- General options -----------");
        System.out.println("Hello, choose an option!");
        System.out.println("1. Add a song");
        System.out.println("2. Add an album");
        System.out.println("3. Add a podcast");
        System.out.println("4. Show all songs");
        System.out.println("5. Show all albums");
        System.out.println("6. Show all podcasts");
        System.out.println("7. Show all users");
        System.out.println("8. Show all playlists");
        System.out.println("9. Delete a song");
        System.out.println("10. Delete an album");
        System.out.println("11. Delete a podcast");
        System.out.println("------------- User options -------------");
        System.out.println("----- Add to queue -----");
        System.out.println("12. Add a song in front queue");
        System.out.println("13. Add a song in back queue");
        System.out.println("14. Add an album in queue");
        System.out.println("15. Add a playlist in queue");
        System.out.println("16. Add a random song in queue");
        System.out.println("----- Queue options -----");
        System.out.println("17. Listen songs from queue");
        System.out.println("18. Clear queue");
        System.out.println("19. Show queue");
        System.out.println("----- Playlist options -----");
        System.out.println("20. Create a playlist");
        System.out.println("21. Add a song to a playlist");
        System.out.println("22. Show your playlists");
        System.out.println("23. Delete a playlist");
        System.out.println("----- Release Radar -----");
        System.out.println("24. Show release radar");
        System.out.println("----- Show info -----");
        System.out.println("25. Show most listened song");
        System.out.println("26. Show total time listened today");

        System.out.println("27. Delete account");
        //
        System.out.println("\n0. Exit app");


    }

    public static Menu getInstance(User user) {
        if (instance == null)
        {
            instance = new Menu(user);
        }
        return instance;
    }

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);

        releaseRadar = new ReleaseRadar();
        releaseRadar.update(SongRepo.getSongList());

        int option;

        do {
            showGeneralOptions();
            option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------------------------");
            switch (option) {
                case 1:
                    addSong();
                    auditService.logAction("Add song");
                    break;
                case 2:
                    addAlbum();
                    auditService.logAction("Add album");
                    break;
                case 3:
                    addPodcast();
                    auditService.logAction("Add podcast");
                    break;
                case 4:
                    showSongs();
                    auditService.logAction("Show songs");
                    break;
                case 5:
                    showAlbums();
                    auditService.logAction("Show albums");
                    break;
                case 6:
                    showPodcasts();
                    auditService.logAction("Show podcasts");
                    break;
                case 7:
                    showUsers();
                    auditService.logAction("Show users");
                    break;
                case 8:
                    showPlaylists();
                    auditService.logAction("Show playlists");
                    break;
                case 9:
                    deleteSong();
                    auditService.logAction("Delete song");
                    break;
                case 10:
                    deleteAlbum();
                    auditService.logAction("Delete album");
                    break;
                case 11:
                    deletePodcast();
                    auditService.logAction("Delete podcast");
                    break;
                case 12:
                    addSongInFrontQueue();
                    auditService.logAction("Add song in front of queue");
                    break;
                case 13:
                    addSongInBackQueue();
                    auditService.logAction("Add song in back of queue");
                    break;
                case 14:
                    addAlbumInQueue();
                    auditService.logAction("Add album to queue");
                    break;
                case 15:
                    addPlaylistInQueue();
                    auditService.logAction("Add playlist to queue");
                    break;
                case 16:
                    addRandomSongInQueue();
                    auditService.logAction("Add random song to queue");
                    break;
                case 17:
                    listenSongsFromQueue();
                    auditService.logAction("Listen to queue");
                    break;
                case 18:
                    clearQueue();
                    auditService.logAction("Clear queue");
                    break;
                case 19:
                    showQueue();
                    auditService.logAction("Show queue");
                    break;
                case 20:
                    createPlaylist();
                    auditService.logAction("Create playlist");
                    break;
                case 21:
                    addSongToPlaylist();
                    auditService.logAction("Add song to playlist");
                    break;
                case 22:
                    showUserPlaylists();
                    auditService.logAction("Show user playlists");
                    break;
                case 23:
                    deletePlaylist();
                    auditService.logAction("Delete playlist");
                    break;
                case 24:
                    showReleaseRadar();
                    auditService.logAction("Show release radar");
                    break;
                case 25:
                    showMostListenedSong();
                    auditService.logAction("Show most listened song");
                    break;
                case 26:
                    showTotalTimeListenedToday();
                    auditService.logAction("Show time listened today");
                    break;
                case 27:
                     boolean deleted = deleteAccount();
                     if (deleted) {
                         auditService.logAction("Delete account");
                         option = 0;
                     }
                    break;
                case 0:
                    System.out.println("Thank you, goodbye!");
                    auditService.logAction("Log out");
                    break;
                default:
                    System.out.println("Wrong option, choose a valid one!");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    private void addSong() {
        Song song = ReadService.readSong(null);
        SongRepo.addSong(song);
        releaseRadar.update(SongRepo.getSongList());
    }

    private void addAlbum() {
        Album album = ReadService.readAlbum();
        AlbumRepo.addAlbum(album);
        releaseRadar.update(SongRepo.getSongList());
    }

    private void addPodcast() {
        Podcast podcast = ReadService.readPodcast();
        PodcastRepo.addPodcast(podcast);
    }

    private void showSongs() {
        SongRepo.showSongs();
    }

    private void showAlbums() {
        AlbumRepo.showAlbums();
    }

    private void showPodcasts() {
        PodcastRepo.showPodcasts();
    }

    private void showPlaylists() { PlaylistRepo.showPlaylists(); }

    private void showUsers() { UserRepo.showUsers(); }

    private void deleteSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The songs in the app are:");
        showSongs();
        System.out.println("Enter song's title to delete:");
        System.out.print(">");
        String title= scanner.nextLine();
        SongRepo.deleteSong(title);
        releaseRadar.update(SongRepo.getSongList());
    }

    private void deleteAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The album in the app are:");
        showAlbums();
        System.out.println("Enter album's title to delete:");
        System.out.print(">");
        String title= scanner.nextLine();
        AlbumRepo.deleteAlbum(title);
        releaseRadar.update(SongRepo.getSongList());
    }

    private void deletePodcast() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The podcasts in the app are:");
        showPodcasts();
        System.out.println("Enter podcast's name to delete:");
        System.out.print(">");
        String name= scanner.nextLine();
        PodcastRepo.deletePodcast(name);
    }

    private void addSongInFrontQueue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The songs in the app are:");
        showSongs();
        System.out.println("Enter song's title to add to front of queue:");
        System.out.print(">");
        String title= scanner.nextLine();
        Song song = SongRepo.getSongByTitle(title);
        loggedInUser.addSongToQueueFront(song);
        System.out.println("Song added to queue front!");
    }

    private void addSongInBackQueue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The songs in the app are:");
        showSongs();
        System.out.println("Enter song's title to add to back of queue:");
        System.out.print(">");
        String title= scanner.nextLine();
        Song song = SongRepo.getSongByTitle(title);
        loggedInUser.addSongToQueueBack(song);
        System.out.println("Song added to queue back!");
    }

    private void addAlbumInQueue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The albums in the app are:");
        showAlbums();
        System.out.println("Enter album's title to add to queue:");
        System.out.print(">");
        String title= scanner.nextLine();
        List<Song> songs = SongRepo.getSongsByAlbum(title);
        loggedInUser.addSongListToQueue(songs);
        System.out.println("Album added to queue!");
    }

    private void addPlaylistInQueue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The albums in the app are:");
        showPlaylists();
        System.out.println("Enter playlist's name to add to queue:");
        System.out.print(">");
        String playlistName= scanner.nextLine();
        List<Song> songs = SongRepo.getSongsByPlaylist(playlistName);
        loggedInUser.addSongListToQueue(songs);
        System.out.println("Playlist added to queue!");
    }

    private void addRandomSongInQueue() {
        loggedInUser.addSongToQueueBack(SongRepo.getRandomSong());
    }

    private void listenSongsFromQueue() {
        loggedInUser.listenToQueue();
    }
    private void clearQueue() {
        loggedInUser.clearQueue();
    }
    private void showQueue() {
        loggedInUser.showQueue();
    }

    private boolean deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete your account? (y/n)");
        String option= scanner.nextLine().toLowerCase();
        if (option.equals("y")) {
            UserRepo.deleteUser(loggedInUser.getUsername());
            return true;
        }

        return false;

    }

    private void createPlaylist() {
        Playlist playlist = ReadService.readPlaylist();
        playlist.setUserName(loggedInUser.getUsername());
        PlaylistRepo.addPlaylist(playlist);
    }

    private void showUserPlaylists() {
        PlaylistRepo.getPlaylistsByUser(loggedInUser.getUsername());
    }

    private void deletePlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your playlists are:");
        showUserPlaylists();
        System.out.println("Enter playlist's name to delete:");
        System.out.print(">");
        String name= scanner.nextLine();
        PlaylistRepo.deletePlaylist(name);
    }

    private void addSongToPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your playlists are:");
        showUserPlaylists();
        System.out.println("Enter playlist's name where you would like to add a song:");
        System.out.print(">");
        String playlistName= scanner.nextLine();
        System.out.println("The songs in the app are:");
        showSongs();
        System.out.println("Enter song's title to add to " + playlistName + " playlist:");
        System.out.print(">");
        String title= scanner.nextLine();
        Song song = SongRepo.getSongByTitle(title);
        PlaylistRepo.addSongToPlaylist(song.getTitle(), playlistName);
        loggedInUser.getPlaylist(playlistName).addSong(song);
    }

    private void showTotalTimeListenedToday() {
        String time = SongRepo.formatDuration(loggedInUser.showTimeListenedToday());
        System.out.println("Today you listened for " + time + "!");
    }

    private void showMostListenedSong() {
        loggedInUser.showMostListenedSong();
    }

    private void showReleaseRadar() {
        releaseRadar.show();
    }
}