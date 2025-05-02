/*
*Your mission is to write a small Java program that proves whether Green Eggs and Ham 
*really uses only 50 different words. You’ll start with two things: an empty Main class 
and a text file that contains the entire story. Your job is to read the file line by 
line and use appropriate skills to see count the number of words. How you do this is up to you!
*/

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        ArrayList<String> words = new ArrayList<>();
        int wordCount = 0;

        try(Scanner scanner = new Scanner(Paths.get("src/greenEggsAndHam.txt"))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                line = line.replace('?', ' ');
                line = line.replace('!', ' ');
                line = line.replace('.', ' ');
                line = line.replace(',', ' ');
                line = line.replace('-', ' ');

                String[] lineWords = line.split(" ");
                for(String word : lineWords){
                    word = word.toLowerCase();
                    if(!words.contains(word) && !word.isEmpty()){
                        words.add(word);
                        wordCount++;
                    }
                }
            }
        }
        System.out.println("The number of unique words in Green Eggs and Ham is: " + wordCount);
    }

}
