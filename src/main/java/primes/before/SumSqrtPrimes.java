package primes.before;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumSqrtPrimes {
    public static void main(String[] args) {
        List<Double> sqrtOfFirst100Primes = new ArrayList<>();

        int index = 2;
        while (sqrtOfFirst100Primes.size() < 100) {
            if (PrimeCalculator.isPrime(index)) {
                sqrtOfFirst100Primes.add(Math.sqrt(index));
            }
            index++;
        }

        System.out.println(sqrtOfFirst100Primes);
    }
}
