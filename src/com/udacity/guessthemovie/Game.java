package com.udacity.guessthemovie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<String> moviesList = new ArrayList<>();
    private int fileLineCounter = 0;
    private String title;

    public String getTitle() {
        return title;
    }

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

    public String pickRandomTitle() {
        int randomNumber = (int) (Math.random() * fileLineCounter);
        title = moviesList.get(randomNumber);
        //test System.out.println(title);
        return title;
    }

    public String convertLettersToUnderscores() {
        String underscoresTitle = title.replaceAll(".", "_");
        return underscoresTitle;
    }

    public char getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().charAt(0);
    }
}
