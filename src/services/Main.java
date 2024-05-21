package services;


import models.User;

public class Main {

    public static void main(String[] args) {



        Menu menu = Menu.getInstance(new User());
        menu.run();

    }
}