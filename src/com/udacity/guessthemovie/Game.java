package com.udacity.guessthemovie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The computer randomly picks a movie title from a large file, and shows you how many letters it's made up of
 * by displaying underscores in place of real letters.
 * Your goal is to try to figure out the movie by guessing one letter at a time.
 * If a letter is indeed in the title the computer will reveal its correct position in the word, if not, you lose a point.
 * If you lose 10 points, game over!
 */
public class Game {
    private List<String> moviesList = new ArrayList<>();
    private int fileLineCounter = 0;
    private String title;

    public String getTitle() {
        return title;
    }

    /**
     * This method reads movies titles line by line from a file and save titles in ArrayList<String>.
     *
     * @param filePath path to the file with data to be read.
     */
    public void readMovieFile(String filePath) {
        File movies = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(movies);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) {
            moviesList.add(scanner.nextLine());
            fileLineCounter++;
        }
        scanner.close();
    }

    /**
     * This method picks random title from ArrayList<String> of movies,
     * by generating random number in a range of List.
     *
     * @return title of random movie as String
     */
    public String pickRandomTitle() {
        int randomNumber = (int) (Math.random() * fileLineCounter);
        title = moviesList.get(randomNumber);
        return title;
    }

    /**
     * This method converts the letters to Underscores
     *
     * @param movie title as String
     * @return title converted into underscores
     */
    public String convertLettersToUnderscores(String movie) {
        String underscoresTitle = movie.replaceAll(".", "_");
        return underscoresTitle;
    }

    /**
     * Asks Player to guess a letter
     *
     * @return the first letter typed by Player as char
     */
    public char getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().charAt(0);
    }
}
