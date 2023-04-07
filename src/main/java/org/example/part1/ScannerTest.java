package org.example.part1;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        String s = new String();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(str);

        int a = scanner.nextInt();
        System.out.println(a);
    }
}
