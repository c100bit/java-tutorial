package org.example.part1;

public class SwitchTest {
    public static void main(String[] args) {
        switch ("test") {
            case "test":
                System.out.println("df");
                break;
            default:
                System.out.println("default");
        }

        int a = switch ("test") {
            case "test" -> 1;
            case "test2" -> 2;
            default -> 3;
        };

        System.out.println(a);
    }
}
