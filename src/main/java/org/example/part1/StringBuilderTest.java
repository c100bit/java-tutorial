package org.example.part1;

public class StringBuilderTest {

    public static void main(String[] args) {
        String s = "some string";
        s.toUpperCase();
        s = s.toUpperCase();
        System.out.println(s);

        StringBuilder str = new StringBuilder();
        str.append("33");
        str.append("tests");
        System.out.println(str);
        System.out.printf("This is string %s %-10d %.2f2 ", "33", 30, 3.3);

    }
}
