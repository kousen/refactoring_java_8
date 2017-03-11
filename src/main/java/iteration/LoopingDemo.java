package iteration;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LoopingDemo {
    private static Logger logger = Logger.getLogger(LoopingDemo.class.getName());

    public static void main(String[] args) {

        List<String> strings = Arrays.asList(
                "this", "is", "a", "list", "of", "strings");
        logger.info(() -> "Here is my message: " + strings.toString());

        // Before:
        for (String s : strings) {
            System.out.println(s);
        }

        // After:
        strings.forEach(System.out::println);

        System.out.println("Joining even length strings:");
        String total = strings.stream()
                .filter(s -> s.length() % 2 == 0)
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
