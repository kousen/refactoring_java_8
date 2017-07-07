package anon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable with an anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("Inside Runnable with a lambda expression")).start();

        List<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        integers.forEach(System.out::println);

        String s = Arrays.stream("this is a list of strings".split(" "))
                .collect(Collectors.joining(","));
        System.out.println(s);

        Stream<String> stream = Arrays.stream(
                "this is a list of strings".split(" "));
        stream.forEach(System.out::println);

        Map<Integer, List<String>> map = Stream.of("this", "is", "a", "list")
                .filter(str -> str.length() >= 2)
                .collect(Collectors.groupingBy(String::length));

        map.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
