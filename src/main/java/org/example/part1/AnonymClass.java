package org.example.part1;

interface Eatable {
    void eat();
}

public class AnonymClass {
    public static void main(String[] args) {
        AnimalTest animal = new AnimalTest();
        animal.eat();

        AnimalTest animal2 = new AnimalTest() {
            void eat() {
                System.out.println("other animal");
            }
        };
        animal2.eat();

        Eatable animal3 = new Eatable() {
            @Override
            public void eat() {
                System.out.println("eatable");
            }
        };
        animal3.eat();
    }
}

class AnimalTest {
    void eat() {
        System.out.println("animal");
    }
}
