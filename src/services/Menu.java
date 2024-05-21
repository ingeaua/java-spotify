package services;

import models.*;
import repositories.*;

import java.util.Scanner;

public class Menu {
    private static Menu instance;
    private User loggedInUser;
    private Menu(User user) {}

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
        System.out.println("8. Delete a song");
        System.out.println("9. Delete an album");
        System.out.println("10. Delete a podcast");

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

        int option;

        do {
            showGeneralOptions();
            option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------------------------");
            switch (option) {
                case 1 -> addSong();
                case 2 -> addAlbum();
                case 3 -> addPodcast();
                case 4 -> showSongs();
                case 5 -> showAlbums();
                case 6 -> showPodcasts();
//                case 7 -> showUsers();
                case 8 -> deleteSong();
                case 9 -> deleteAlbum();
                case 10 -> deletePodcast();


                case 0 -> System.out.println("Thank you, goodbye!");
                default -> System.out.println("Wrong option, choose a valid one!");
            }
        } while (option != 0);

        scanner.close();
    }

    public void addSong() {
        Song song = ReadService.readSong(null);
        SongRepo.addSong(song);
    }

    public void addAlbum() {
        Album album = ReadService.readAlbum();
        AlbumRepo.addAlbum(album);
    }

    public void addPodcast() {
        Podcast podcast = ReadService.readPodcast();
        PodcastRepo.addPodcast(podcast);
    }

    public void showSongs() {
        SongRepo.showSongs();
    }

    public void showAlbums() {
        AlbumRepo.showAlbums();
    }

    public void showPodcasts() {
        PodcastRepo.showPodcasts();
    }

    public void deleteSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The songs in the app are:");
        showSongs();
        System.out.println("Enter song's title to delete:");
        System.out.print(">");
        String title= scanner.nextLine();
        SongRepo.deleteSong(title);
    }

    public void deleteAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The album in the app are:");
        showAlbums();
        System.out.println("Enter album's title to delete:");
        System.out.print(">");
        String title= scanner.nextLine();
        AlbumRepo.deleteAlbum(title);
    }

    public void deletePodcast() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The podcasts in the app are:");
        showPodcasts();
        System.out.println("Enter podcast's name to delete:");
        System.out.print(">");
        String name= scanner.nextLine();
        PodcastRepo.deletePodcast(name);
    }
}