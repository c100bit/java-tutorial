package org.example.part2.regexp;

import java.util.Arrays;

public class RegExpTest {
    public static void main(String[] args) {
        String a = "1234";
        String b = "-1234";
        String c = "+1234";
        System.out.println(c.matches("(-|\\+)?\\d+"));
        String d = "bs3df3123451";
        System.out.println(d.matches("[a-zA-Z3]+\\d+"));

        String e = "hella";
        System.out.println(e.matches("[^abc]*"));

        String url = "http://www.google.com1";
        System.out.println(url.matches("http://www\\..+\\.(ru|com)"));

        String f = "hello world";
        System.out.println(Arrays.toString(f.split("\\s")));
        System.out.println(f.replaceAll("\\s", "."));

    }
}
