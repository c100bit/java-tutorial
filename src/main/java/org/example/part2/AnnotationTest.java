package org.example.part2.annotations;

public class AnnotationTest {
    public static void main(String[] args) {

    }

    @MethodInfo(purpose = "print")
    public void printHelloWorld() {
        System.out.println("hello");
    }
}
