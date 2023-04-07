package org.example.annotations;

public class AnnotationTest {
    public static void main(String[] args) {

    }

    @MethodInfo(purpose = "print")
    public void printHelloWorld() {
        System.out.println("hello");
    }
}
