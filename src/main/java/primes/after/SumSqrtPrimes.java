package primes.after;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ken Kousen on 10/14/16.
 */
public class SumSqrtPrimes {
    public static void main(String[] args) {

        List<Double> sqrtOfFirst100Primes =
                Stream.iterate(1, e -> e + 1)
                        .filter(PrimeCalculator::isPrime)
                        .limit(100)
                        .peek(System.out::println)
                        .map(Math::sqrt)
                        .collect(Collectors.toList());
        System.out.println(sqrtOfFirst100Primes);
    }
}