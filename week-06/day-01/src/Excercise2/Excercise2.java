package Excercise2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Excercise2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        List<Integer> sqit uaredNumbers = numbers.stream()
                .filter(number -> number > 0)
                .map(number -> number * number)
                .collect(Collectors.toList());

        System.out.println(squaredNumbers);
    }



}
