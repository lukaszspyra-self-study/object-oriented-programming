package com.udacity.filewordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        File book = new File("Pride and Prejudice (project Gutenberg).txt");
        Scanner scanner = new Scanner(book);
        int totalWords = 0;

        //calculates total words of book (all strings spilt by space
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            totalWords += line.split(" ").length;
        }
        System.out.println(totalWords);
    }
}
