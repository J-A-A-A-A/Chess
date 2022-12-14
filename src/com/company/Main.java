package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Chess");
        Chess game = new Chess();
        game.display();
        game.move();
        game.display();
    }
}
