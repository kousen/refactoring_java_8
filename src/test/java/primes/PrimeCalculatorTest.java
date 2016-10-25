package primes;

import org.junit.Test;
import primes.after.PrimeCalculator;

import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeCalculatorTest {

    @Test
    public void isPrime() throws Exception {
        IntStream.of(2, 3, 5, 7, 11, 13, 17, 19)
                .forEach(p -> {
                    assertTrue(PrimeCalculator.isPrime(p));
                });
    }

    @Test
    public void isComposite() throws Exception {
        IntStream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20)
                .forEach(p -> {
                    assertFalse(PrimeCalculator.isPrime(p));
                });
    }

}