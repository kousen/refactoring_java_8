package strategy;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class SumNumbers {
    public static final IntPredicate EVENS = n -> n % 2 == 0;
    public static final IntPredicate ODDS = n -> n % 2 != 0;
    public static final IntPredicate GT5 = n -> n > 5;



    public int sumUpToN(int n) {
        return IntStream.rangeClosed(1, n)
                .sum();
    }

    public int sumEvensUpToN(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(val -> val % 2 == 0)
                .sum();
    }

    public int sumOddsUpToN(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(val -> val % 2 != 0)
                .sum();
    }

    public int sumFilterUpToN(int n, IntPredicate condition) {
        return IntStream.rangeClosed(1, n)
                .filter(condition)
                .sum();
    }
}
