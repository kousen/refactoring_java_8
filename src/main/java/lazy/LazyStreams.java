package lazy;

import java.util.stream.IntStream;

public class LazyStreams {

    public static int multByTwo(int n) {
        System.out.printf("Inside multByTwo with arg %d%n", n);
        return n * 2;
    }

    public static boolean divByThree(int n) {
        System.out.printf("Inside divByThree with arg %d%n", n);
        return n % 3 == 0;
    }

    public static void main(String[] args) {
        // Find first even double between 200 and 400 divisble by 3
        int firstEvenDoubleDivBy3 = IntStream.range(100, 200)
                .map(n -> n * 2)
                .filter(n -> n % 3 == 0)
                .findFirst().orElse(0);
        System.out.println(firstEvenDoubleDivBy3);

        // Demonstrate laziness using print statements
        firstEvenDoubleDivBy3 = IntStream.range(100, 200)
                .map(LazyStreams::multByTwo)
                .filter(LazyStreams::divByThree)
                .findFirst().orElse(0);
        System.out.printf("First even divisible by 3 is %d%n", firstEvenDoubleDivBy3);
    }
}
