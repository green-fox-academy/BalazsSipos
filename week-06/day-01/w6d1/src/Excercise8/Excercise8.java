package Excercise8;

import java.util.Arrays;
import java.util.List;

public class Excercise8 {
    public static void main(String[] args) {
        // Write a Stream Expression to concatenate a Character list to a string!

        List<String> charList =Arrays.asList("a", "b", "c", "D");

        String concatenatedChars = charList.stream()
                                            .reduce("", (collector, tempChar) -> collector.concat(tempChar));
        System.out.println(concatenatedChars);
    }
}
