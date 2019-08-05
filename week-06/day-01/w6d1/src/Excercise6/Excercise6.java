package Excercise6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Excercise6 {
    public static void main(String[] args) {
        // Write a Stream Expression to find the uppercase characters in a string!
        String word = "AbCd";

        List<String> chars = new ArrayList<String>(Arrays.asList(word.split("")));

        List<String> uppChars = chars.stream()
                .filter(letter -> letter == letter.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(uppChars);
    }
}
