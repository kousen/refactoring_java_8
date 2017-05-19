package iteration;

import java.util.Arrays;
import java.util.List;

public class IterableDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        for (String s : strings) {
            System.out.println(s);
        }

        strings.forEach(System.out::println);
    }
}
