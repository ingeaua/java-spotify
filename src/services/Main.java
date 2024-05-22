package services;

import models.User;
import repositories.UserRepo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int option;

        System.out.println("Hello, welcome to the app!");
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("0. Exit app");
        option = scanner.nextInt();
        scanner.nextLine();
        System.out.println("----------------------------------------");
        switch (option) {
            case 1 -> logIn();
            case 2 -> createUser();

            case 0 -> System.out.println("Thank you, goodbye!");
            default -> System.out.println("Wrong option, choose a valid one!");
        }

        scanner.close();

    }

    private static void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email:");
        System.out.print(">");
        String email= scanner.nextLine();
        System.out.println("Enter password:");
        System.out.print(">");
        String password= scanner.nextLine();
        User user = UserRepo.logIn(email, password);
        if (user != null) {

            Menu menu = Menu.getInstance(user);
            menu.run();
        }
        else {
            System.out.println("Wrong log in information, please try again!");
        }
    }

    private static void createUser() {
        User user = ReadService.readUser();
        UserRepo.addUser(user);

        Menu menu = Menu.getInstance(user);
        menu.run();
    }
}