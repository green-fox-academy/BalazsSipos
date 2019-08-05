package Excercise9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Excercise9 {
    public static void main(String[] args) {
        // Write a Stream Expression to find the frequency of characters in a given string!

        String example = "ababcb";
        List<String> charList = Arrays.asList(example.split(""));

        Map<Object, Long> charMap = charList.stream()
                                                .collect(groupingBy(c -> c, Collectors.counting()));
        System.out.println(charMap);
    }


}
