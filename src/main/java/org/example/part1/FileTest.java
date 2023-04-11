package org.example.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) throws FileNotFoundException {
        String sep = File.separator;
        File file = new File(sep + "some.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

    
    }

}
