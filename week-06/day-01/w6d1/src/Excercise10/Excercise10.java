package Excercise10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Excercise10 {
    public static void main(String[] args) {
        //Create a Fox class with 3 properties:name, color and age Fill a list with at least 5 foxes and:
        //
        //Write a Stream Expression to find the foxes with green color!

        Excercise10 excercise10 = new Excercise10();

        List<Fox> foxes = excercise10.createFoxes();
        List<String> namesOfGreenFoxes = foxes.stream()
                                                .filter(fox -> fox.color.equals("green"))
                                                .map(fox -> fox.name)
                                                .collect(Collectors.toList());

        System.out.println(namesOfGreenFoxes);

        //Write a Stream Expression to find the foxes with green color, and age less then 5 years!
        List<String> namesOfGreenYoungFoxes = foxes.stream()
                                                    .filter(fox -> (fox.color.equals("green") && fox.age < 5))
                                                    .map(fox -> fox.name)
                                                    .collect(Collectors.toList());
        System.out.println(namesOfGreenYoungFoxes);

        //Write a Stream Expression to find the frequency of foxes by color!
        Map<Object, Long> numberByColor = foxes.stream()
                                                    .collect(Collectors.groupingBy(c -> c.color, Collectors.counting()));
        System.out.println(numberByColor);
    }

    private List<Fox> createFoxes() {
        List<Fox> foxes = new ArrayList<Fox>();
        foxes.add(new Fox("name1", "green", 1));
        foxes.add(new Fox("name2", "red", 2));
        foxes.add(new Fox("name3", "white", 4));
        foxes.add(new Fox("name4", "green", 5));
        foxes.add(new Fox("name5", "red", 2));

        //System.out.println(foxes);
        return foxes;
    }
}
