package primes.after;

import java.util.stream.IntStream;

/**
 * Created by Ken Kousen on 10/14/16.
 */
public class PrimeCalculator {
    public static boolean isPrime(int number) {
        int max = (int) (Math.sqrt(number) + 1);
        return number > 1 &&
                IntStream.range(2, max)
                        .noneMatch(index -> number % index == 0);
    }
}
