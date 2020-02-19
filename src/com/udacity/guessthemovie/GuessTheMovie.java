package com.udacity.guessthemovie;

import java.util.Arrays;

public class GuessTheMovie {
    Game game;
    int mistakeCounter;

    public GuessTheMovie() {
        game = new Game();
        mistakeCounter = 0;
    }

    public void prepareGame() {
        game.readMovieFile("movies.txt");
        game.pickRandomTitle();
        game.convertLettersToUnderscores();
    }

    public void gameStart() {
        System.out.println("Hi! Try to figure out the movie by guessing one letter at a time!");
        System.out.println("Your mysterious title contains " + game.getTitle().length() + " letters,");
    }

    public String gamePlay() {
        String gameResult = "Game Over. Try again.";
        String underscoreTitle = game.convertLettersToUnderscores();
        char[] arrayTitle = game.getTitle().toCharArray();
        char[] arrayUnderscoreTitle = game.convertLettersToUnderscores().toCharArray();
        StringBuilder wrongLetters = new StringBuilder();
        while (mistakeCounter <= 10) {
            System.out.println("You are guessing: " + String.valueOf(arrayUnderscoreTitle));
            System.out.println("You have guessed (" + mistakeCounter + " of 10) wrong letters: " + wrongLetters);
            System.out.print("Guess a letter: ");
            char letterGuess = game.getUserInput();
            if (game.getTitle().indexOf(letterGuess) == -1) {
                if(wrongLetters.indexOf(String.valueOf(letterGuess)) == -1) {
                    wrongLetters.append(letterGuess);
                    mistakeCounter++;
                }
            } else {
                for (int i = 0; i < game.getTitle().length(); i++) {
                    if (letterGuess == arrayTitle[i]) {
                        arrayUnderscoreTitle[i] = letterGuess;
                    }
                }
            }
            if (Arrays.equals(arrayTitle, arrayUnderscoreTitle)) {
                System.out.println("You win!");
                gameResult = ("You have guessed " + game.getTitle() + " correctly.");
                break;
            }
        }
     return gameResult;
    }

    public static void main(String[] args) {
        GuessTheMovie guessTheMovie = new GuessTheMovie();
        guessTheMovie.prepareGame();
        guessTheMovie.gameStart();
        System.out.println(guessTheMovie.gamePlay());
    }
}


