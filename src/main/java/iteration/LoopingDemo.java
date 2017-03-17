package iteration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LoopingDemo {
    private static Logger logger = Logger.getLogger(LoopingDemo.class.getName());

    public static void main(String[] args) {

        List<String> strings = Arrays.asList(
                "this", "is", "a", "list", "of", "strings");
        // logger.info(() -> "Here is my message: " + strings.toString());

        // Before:
        for (String s : strings) {
            System.out.println(s);
        }

        // After:
        strings.forEach(x -> System.out.println(x));
        strings.forEach(System.out::println);

        strings = Arrays.asList(
                "this", "is", null, "a", "list", null, "of", "strings");
        System.out.println("Lengths: ");
        strings.stream()
                .filter(Objects::nonNull)
                .forEach(s -> System.out.println(s.length()));


        Predicate<String> evens = s -> s.length() % 2 == 0;
        Predicate<String> nonNull = Objects::nonNull;

        System.out.println("Joining even length strings:");
        String total = strings.stream()
                .filter(nonNull.and(evens))
                .map(s -> {
                    System.out.println(s);
                    return s;
                })
                .peek(s -> System.out.println("The value of s is " + s))
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
        System.out.println(total);
    }
}
