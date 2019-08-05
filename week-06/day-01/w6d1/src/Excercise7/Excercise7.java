package Excercise7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Excercise7 {
    public static void main(String[] args) {
        // Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:

        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

        Excercise7 excercise7 = new Excercise7();
        System.out.println(excercise7.stringFinder(cities, "r"));
    }

    private List<String> stringFinder(List<String> citiesList, String firstLetter) {
        return citiesList.stream()
                                            .filter(city -> city.substring(0,1).toUpperCase().equals(firstLetter.toUpperCase()))
                                            .collect(Collectors.toList());
    }
}
