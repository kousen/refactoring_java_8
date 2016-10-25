package iteration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FactorialService {

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
                .reduce(1, (total, eachValue) -> total * eachValue);
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
                .reduce(0, (acc, val) -> acc + 2 * val);
    }
}
