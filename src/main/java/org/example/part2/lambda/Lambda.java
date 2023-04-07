package org.example.part2.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface Executable {
    int execute(int x);

}

class Runner {
    public void run(Executable executable) {
        executable.execute(14);
    }
}

class ExecutableImplementation implements Executable {

    @Override
    public int execute(int x) {
        System.out.println("ExecutableImplementation" + x);
        return 0;
    }


}

public class Lambda {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("lambda1"));
        Thread thread2 = new Thread(() -> {
            System.out.println("lambda2");
        });

        Runner runner = new Runner();
        runner.run(new ExecutableImplementation());

        runner.run(new Executable() {
            int a = 1;

            @Override
            public int execute(int x) {
                int a = 2;
                System.out.println("Executable" + a);
                return 0;
            }


        });

        runner.run((x) -> {
            System.out.println("Lambda" + x);
            return 5;
        });
        runner.run((int x) -> x);
        int a = 10;
        runner.run(x -> {
            int b = 10;
            return x + b;
        });
        int b = 10;
        System.out.println(b);

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("goodbye");
        list.add("blink");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() < o2.length() ? 1 : -1;
            }
        });

        System.out.println(list);
        list.sort((a1, a2) -> a1.length() < a2.length() ? -1 : 1);

        System.out.println(list);

        Comparator<String> comparator = (a1, a2) -> a1.length() < a2.length() ? -1 : 1;
        list.sort(comparator);
    }
}