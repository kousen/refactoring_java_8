package strategy;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class SumNumbersTest {
    private SumNumbers sum = new SumNumbers();

    @Test
    public void sumUpToN() throws Exception {
        assertEquals(55, sum.sumUpToN(10));
    }

    @Test
    public void sumEvensUpToN() throws Exception {
        assertEquals(2 + 4 + 6 + 8 + 10, sum.sumEvensUpToN(10));
    }

    @Test
    public void sumOddsUpToN() throws Exception {
        assertEquals(1 + 3 + 5 + 7 + 9, sum.sumOddsUpToN(10));
    }

    private boolean perfectSquare(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    @Test
    public void sumFilterUpToN() throws Exception {
        assertEquals(55,
                sum.sumFilterUpToN(10, val -> true));
        assertEquals(2 + 4 + 6 + 8 + 10,
                sum.sumFilterUpToN(10, SumNumbers.EVENS));
        assertEquals(1 + 3 + 5 + 7 + 9,
                sum.sumFilterUpToN(10, SumNumbers.ODDS));
        assertEquals(7 + 9,
                sum.sumFilterUpToN(10, SumNumbers.ODDS.and(SumNumbers.GT5)));
        assertEquals(1 + 4 + 9, sum.sumFilterUpToN(10, this::perfectSquare));
    }

}