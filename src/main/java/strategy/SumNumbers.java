package strategy;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Created by Ken Kousen on 10/14/16.
 */
public class SumNumbers {
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
