package org.example.part1;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        test(animals);
        List<Dog> dogs = new ArrayList<>();
        test(dogs);
    }

    static void test(List<? extends Animal> list) {
    }
}

class Animal {

}

class Dog extends Animal {

}
