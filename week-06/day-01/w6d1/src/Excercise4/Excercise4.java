package Excercise4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Excercise4 {
    public static void main(String[] args) {
        // Write a Stream Expression to get the average value of the odd numbers from the following list:

        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        double average = numbers.stream()
                .filter(number -> (number % 2 == 1) || number % 2 == -1)
                .mapToDouble(number -> number)
                .average()
                .getAsDouble();

        double sum = numbers.stream()
                .filter(number -> (number % 2 == 1) || number % 2 == -1)
                .mapToDouble(number -> number)
                .sum();

        double count = numbers.stream()
                .filter(number -> (number % 2 == 1) || number % 2 == -1)
                .mapToDouble(number -> number)
                .count();

        List<Integer> counter = numbers.stream()
                .filter(number -> (number % 2 == 1) || number % 2 == -1)
                .collect(Collectors.toList());

        System.out.println(average);
        System.out.println(sum);
        System.out.println(count);
        System.out.println(counter);
    }
}
