package services;
import models.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class ReadService {

    static Scanner scanner = new Scanner(System.in);
    public static Song readSong(String artist) {

        System.out.println("Enter song's title:");
        System.out.print(">");
        String title= scanner.nextLine();
        System.out.println("Enter song's genre:");
        System.out.print(">");
        String genre= scanner.nextLine();
        if (artist == null) {
            System.out.println("Enter song's artist:");
            System.out.print(">");
            artist = scanner.nextLine();
        }
        System.out.println("Enter song's duration:");
        System.out.print(">");
        int duration= scanner.nextInt();
        scanner.nextLine();

        return new Song(title, genre, artist, duration);
    }

    public static Album readAlbum() {
        System.out.println("Enter album's title:");
        System.out.print(">");
        String title= scanner.nextLine();
        System.out.println("Enter album's genre:");
        System.out.print(">");
        String genre= scanner.nextLine();
        System.out.println("Enter album's artist:");
        System.out.print(">");
        String artist= scanner.nextLine();
        System.out.println("Enter album's number of songs:");
        System.out.print(">");
        int songCount= scanner.nextInt();
        scanner.nextLine();

        List<Song> songsList = new ArrayList<>();

        for (int i = 1; i <= songCount; i++) {
            System.out.println("Enter information about song " + i + ":");
            Song song = readSong(artist);
            song.setAlbum(title);
            songsList.add(song);
        }

        return new Album(title, artist, songsList, genre);
    }

    public static Podcast readPodcast() {

        System.out.println("Enter podcast's name:");
        System.out.print(">");
        String name= scanner.nextLine();
        System.out.println("Enter podcast's creator:");
        System.out.print(">");
        String creator= scanner.nextLine();
        System.out.println("Enter podcast's duration:");
        System.out.print(">");
        int duration= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter podcast's topic:");
        System.out.print(">");
        String topic= scanner.nextLine();

        return new Podcast(name, creator, duration, topic);
    }

    public static User readUser() {
        System.out.println("Enter username:");
        System.out.print(">");
        String username= scanner.nextLine();

        System.out.println("Enter password:");
        System.out.print(">");
        String password= scanner.nextLine();

        System.out.println("Enter email:");
        System.out.print(">");
        String email= scanner.nextLine();

        return new User(username, password, email);

    }
}
