package org.example.part2.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchers {
    public static void main(String[] args) {
        String text = "hello this tim1@gmail.ru is test\n" +
                "keep in touch. tim@yandex.ru thanks joe";

        Pattern email = Pattern.compile("\\w+@(gmail|yandex)\\.((co)qm|ru)");
        Matcher matcher = email.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
