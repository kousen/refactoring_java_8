package iteration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ken Kousen on 10/14/16.
 */
public class FactorialServiceTest {
    private FactorialService service = new FactorialService();

    @Test
    public void testAddValues() {
        assertEquals(55, service.addValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testDoubledValues() {
        assertEquals(110, service.addDoubledValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void joinNumbers() {
        String s = service.joinNumbers(1, 2, 3, 4, 5);
        assertEquals("1,2,3,4,5", s);
    }

    @Test
    public void joinNumbersWithNulls() {
        String s = service.joinNumbers(1, null, 2, 3, null, 4, 5);
        assertEquals("1,2,3,4,5", s);
    }

    @Test
    public void joinEvenNumbers() {
        String s = service.joinEvenNumbers(1, 2, 3, 4, 5);
        assertEquals("2,4", s);
    }

    @Test
    public void joinNumbersWithFilter() {
        assertEquals("2,4",
                service.joinNumbersWithFilter(n -> n % 2 == 0,
                        1, 2, 3, 4, 5));
        assertEquals("1,3,5",
                service.joinNumbersWithFilter(n -> n % 2 != 0,
                        1, 2, 3, 4, 5));
    }

    @Test
    public void recursive() throws Exception {
        assertEquals(1L, service.recursive(0));
        assertEquals(1L, service.recursive(1));
        assertEquals(2L, service.recursive(2));
        assertEquals(3L * 2L, service.recursive(3));
        assertEquals((long) (4 * 3 * 2), service.recursive(4));
        assertEquals((long) (6 * 5 * 4 * 3 * 2), service.recursive(6));
    }

    @Test
    public void iterative() throws Exception {
        assertEquals(1L, service.iterative(0));
        assertEquals(1L, service.iterative(1));
        assertEquals(2L, service.iterative(2));
        assertEquals(3L * 2L, service.iterative(3));
        assertEquals((long) (4 * 3 * 2), service.iterative(4));
        assertEquals((long) (6 * 5 * 4 * 3 * 2), service.iterative(6));
    }

    @Test
    public void functional() throws Exception {
        assertEquals(1L, service.functional(0));
        assertEquals(1L, service.functional(1));
        assertEquals(2L, service.functional(2));
        assertEquals(3L * 2L, service.functional(3));
        assertEquals((long) (4 * 3 * 2), service.functional(4));
        assertEquals((long) (6 * 5 * 4 * 3 * 2), service.iterative(6));
    }
}