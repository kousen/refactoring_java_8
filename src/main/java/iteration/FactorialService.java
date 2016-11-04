package iteration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FactorialService {
    public static final Predicate<Integer> EVENS = n -> n % 2 == 0;
    public static final Predicate<Integer> ODDS = n -> n % 2 != 0;

    public long recursive(long n) {
        if (n == 0) return 1;
        return n * recursive(n - 1);
    }

    public long iterative(long n) {
        if (n == 0) return 1;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public long functional(long n) {
        if (n == 0) return 1;
        return LongStream.rangeClosed(1, n)
                .reduce(
                        (total, eachValue) -> {
                            System.out.printf("total=%d, eachValue=%d%n", total, eachValue);
                            return total * eachValue;
                        }).orElse(1);
    }

    public String joinStrings() {
        return Stream.of("This", "is", "a", "stream", "of", "strings")
                .reduce((total, s) -> total + " " + s).orElse("");
    }

    public String joinNumbers(Integer... values) {
        return Arrays.stream(values)
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    public String joinEvenNumbers(Integer... values) {
        return Arrays.stream(values)
                .filter(Objects::nonNull)
                .filter(n -> n % 2 == 0)
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    public String joinNumbersWithFilter(Predicate<Integer> pred, Integer... values) {
        return Arrays.stream(values)
                .filter(Objects::nonNull)
                .filter(pred)
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    public int addValues(int... values) {
        return Arrays.stream(values)
                .sum();
    }

    public int addDoubledValues(Integer... values) {
        return Arrays.stream(values)
                .reduce(0,(acc, val) -> {
                    System.out.println("acc=" + acc + ", val=" + val);
                    return acc + 2 * val;
                });
    }
}
