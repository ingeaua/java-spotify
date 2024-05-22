package services;

import models.*;
import repositories.*;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Menu instance;
    private User loggedInUser;
    private ReleaseRadar releaseRadar;
    private Menu(User user) {loggedInUser = user;}

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

    public void run() {
        Scanner scanner = new Scanner(System.in);

        releaseRadar = ReleaseRadarRepo.getReleaseRadar();

        int option;

        do {
            showGeneralOptions();
            option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------------------------");
            switch (option) {
                case 1:
                    addSong();
                    break;
                case 2:
                    addAlbum();
                    break;
                case 3:
                    addPodcast();
                    break;
                case 4:
                    showSongs();
                    break;
                case 5:
                    showAlbums();
                    break;
                case 6:
                    showPodcasts();
                    break;
                case 7:
                    showUsers();
                    break;
                case 8:
                    showPlaylists();
                    break;
                case 9:
                    deleteSong();
                    break;
                case 10:
                    deleteAlbum();
                    break;
                case 11:
                    deletePodcast();
                    break;
                case 12:
                     addSongInFrontQueue();
                    break;
                case 13:
                     addSongInBackQueue();
                    break;
                case 14:
                     addAlbumInQueue();
                    break;
                case 15:
                     addPlaylistInQueue();
                    break;
                case 16:
                     addRandomSongInQueue();
                    break;
                case 17:
                     listenSongsFromQueue();
                    break;
                case 18:
                     clearQueue();
                    break;
                case 19:
                     showQueue();
                    break;
                case 20:
                    // createPlaylist();
                    break;
                case 21:
                    // addSongToPlaylist();
                    break;
                case 22:
                    // showUserPlaylists();
                    break;
                case 23:
                    // deletePlaylist();
                    break;
                case 24:
                    // showReleaseRadar();
                    break;
                case 25:
                    // showMostListenedSong();
                    break;
                case 26:
                    // showTotalTimeListenedToday();
                    break;
                case 27:
                    // deleteAccount();
                    break;
                case 0:
                    System.out.println("Thank you, goodbye!");
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
    }

    private void addAlbum() {
        Album album = ReadService.readAlbum();
        AlbumRepo.addAlbum(album);
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
    }

    private void deleteAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The album in the app are:");
        showAlbums();
        System.out.println("Enter album's title to delete:");
        System.out.print(">");
        String title= scanner.nextLine();
        AlbumRepo.deleteAlbum(title);
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
        showSongs();
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
}