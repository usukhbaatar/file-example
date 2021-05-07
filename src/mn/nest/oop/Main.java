package mn.nest.oop;

/*
1. test.txt файлаас үгүүдийг уншиж авна
    M    -> мөрийн тоо
    word1 x
    word2 y
    ...
2. Гараас N тоо уншиж авна
    word1
    word2
    ...


File:
3
good 1
bad 2
other 2
STDIN:
3
good
other
next

Output > File
4
good 2
bad 2
other 3
next 1

1. Read from file (test.txt)
2. Merge words
3. Write to file (test.txt)

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // global static vector
    private static ArrayList<WordCount> list = new ArrayList<WordCount>();

    public static void readFromFile() {
        try {
            File file = new File("test.txt");
            Scanner scanner = new Scanner(file);
            int M = scanner.nextInt();
            String word; int count;
            for (int i = 0; i < M; i++) {
                word = scanner.next();
                count = scanner.nextInt();
                WordCount wc = new WordCount(word, count);
                list.add(wc);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // 1. file not found
            // 2. permission
            // e.printStackTrace();
        }
    }

    public static void readFromStdin() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String word;
        for (int i = 0; i < N; i++) {
            word = scanner.next();
            boolean found = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getWord().equals(word)) {  // string a == string b
                    list.get(j).addCount(); // count++;
                    found = true;
                }
            }
            if (!found) { // list дотор байгаагүй бол
                WordCount wc = new WordCount(word);
                list.add(wc);
            }
        }
    }

    public static void saveWords() {
        try {
            // файл үүсгэх
            File file = new File("test.txt");
            file.createNewFile();

            // file руу хэвлэх
            FileWriter writer = new FileWriter("test.txt");

            writer.write(list.size() + "\n");
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i).toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
	    // 1. Read from file;
        readFromFile();

        readFromStdin();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        saveWords();

        return;
    }
}
