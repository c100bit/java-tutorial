package org.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPart2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();
        fill(arr);
        System.out.println(Arrays.toString(arr));

        arr = Arrays.stream(arr).map(i -> i + 2).filter(i -> i > 3).toArray();
        list = list.stream().map(i -> i + 3).collect(Collectors.toList());
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.stream(arr).reduce(0, (acc, b) -> acc + b));
    }

    public static void fill(int[] list) {
        for (int i = 0; i < 10; i++)
            list[i] = i + 1;
    }
}



