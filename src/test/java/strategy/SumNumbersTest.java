package strategy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ken Kousen on 10/14/16.
 */
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

    @Test
    public void sumFilterUpToN() throws Exception {
        assertEquals(55,
                sum.sumFilterUpToN(10, val -> true));
        assertEquals(2 + 4 + 6 + 8 + 10,
                sum.sumFilterUpToN(10, val -> val % 2 == 0));
        assertEquals(1 + 3 + 5 + 7 + 9,
                sum.sumFilterUpToN(10, val -> val % 2 != 0));
    }

}