package org.example.part2.testing;

public class MyMath {
    public static double divide(int number1, int number2) {
        if (number2 == 0)
            throw new ArithmeticException("Cant divide by zero");
        return number1 / number2;
    }
}
