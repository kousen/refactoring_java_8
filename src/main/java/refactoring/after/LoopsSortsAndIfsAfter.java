package refactoring.after;

import java.util.*;
import java.util.stream.Collectors;

public class LoopsSortsAndIfsAfter {
    public static void main(String[] args) {
        String[] strings = "this is an array of strings".split(" ");

        List<String> evens = new ArrayList<>();
        for (String s : strings) {
            if (s.length() % 2 == 0) {
                evens.add(s);
            }
        }

        Collections.sort(evens, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (String s : evens) {
            System.out.println(s);
        }
    }
}
