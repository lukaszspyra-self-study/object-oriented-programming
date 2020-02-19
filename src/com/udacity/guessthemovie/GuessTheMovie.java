package com.udacity.guessthemovie;

import java.util.Arrays;

/**
 * Guess the Movie prepares and starts the actual game and checks letters being guessed by the Player.
 * Displays: Game Over! or You Win.
 */
public class GuessTheMovie {
    Game game;
    int mistakeCounter;

    /**
     * Constructor sets the mistake counter to 0
     */
    public GuessTheMovie() {
        game = new Game();
        mistakeCounter = 0;
    }

    /**
     * prepareGame call methods of Game class to read movies from file and pick random title in order to start game.
     */
    public void prepareGame() {
        game.readMovieFile("movies.txt");
        game.pickRandomTitle();
    }

    /**
     * gameStart displays messages to Player with short description and number of letter of the movie to be figured out.
     */
    public void gameStart() {
        System.out.println("Hi! Try to figure out the movie by guessing one letter at a time!");
        System.out.println("Your mysterious title contains " + game.getTitle().length() + " letters,");
    }

    /** gamePlay is performing the game process, checking the letters typed by the Player, deciding about the game result.
     *
     * @return message if Player have won or lost as String.
     */
    public String gamePlay() {
        String gameResult = "Game Over. Try again.";
        char[] arrayTitle = game.getTitle().toCharArray();
        char[] arrayUnderscoreTitle = game.convertLettersToUnderscores(game.getTitle()).toCharArray();
        StringBuilder wrongLetters = new StringBuilder();
        while (mistakeCounter <= 10) {
            System.out.println("You are guessing: " + String.valueOf(arrayUnderscoreTitle));
            System.out.println("You have guessed (" + mistakeCounter + " of 10) wrong letters: " + wrongLetters);
            System.out.print("Guess a letter: ");
            char letterGuess = game.getUserInput();
            if (game.getTitle().indexOf(letterGuess) == -1) {
                if (wrongLetters.indexOf(String.valueOf(letterGuess)) == -1) {
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


