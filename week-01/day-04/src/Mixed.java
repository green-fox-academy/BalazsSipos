import java.util.HashMap;
import java.util.Map;

public class Mixed {
    //volume = abc
    //surfArea = 2(ab+ac +bc)
    public static void main(String[] args) {
        HashMap<Integer, Character> firstHMap = new HashMap<Integer, Character>();

        System.out.println(firstHMap.isEmpty());

        firstHMap.put(97, 'a');
        firstHMap.put(98, 'b');
        firstHMap.put(99, 'c');
        firstHMap.put(65, 'A');
        firstHMap.put(66, 'B');
        firstHMap.put(67, 'C');

        for (Map.Entry<Integer, Character> entry : firstHMap.entrySet()) {
            System.out.print(entry.getKey() + ", ");

            System.out.print(entry.getValue() + ", ");
        }
        for (Map.Entry<Integer, Character> entry : firstHMap.entrySet()) {
            System.out.print(entry.getValue() + ", ");
        }
        firstHMap.put(68, 'D');
        System.out.println();
        System.out.println(firstHMap.size());
        System.out.println(firstHMap.get(99));
        firstHMap.remove(97);
        System.out.println(firstHMap.size());
        System.out.println(firstHMap.get(100));
        firstHMap.clear();
        System.out.println(firstHMap.isEmpty());



    }
}
