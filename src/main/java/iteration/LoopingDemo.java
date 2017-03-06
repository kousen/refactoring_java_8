package iteration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoopingDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        // Before:
        for (String s : strings) {
            System.out.println(s);
        }

        // After:
        strings.forEach(System.out::println);

        String total = strings.stream()
//                .map(s -> {
//                    System.out.println("Before filter: s = " + s);
//                    return s;
//                })
                .peek(s -> System.out.println("Before filter: s = " + s))
                .filter(s -> s.length() % 2 == 0)
                .peek(s -> System.out.println("After filter: s = " + s))
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
        System.out.println(total);
    }
}
