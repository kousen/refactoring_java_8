package concurrent;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreams {
    private static IntConsumer printAfterDelay() {
        return n -> {
            try {
                Thread.sleep(100);
                System.out.println(n + " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
            }
        };
    }

    public static String printSequential(int max) {
        long start = System.nanoTime();
        IntStream.rangeClosed(1, max)
                .forEach(printAfterDelay());
        long end = System.nanoTime();
        return String.format("time: %ssec\n", (end - start) / 1e9);
    }

    public static String printParallel(int max) {
        long start = System.nanoTime();
        IntStream.rangeClosed(1, max)
                .parallel()
                .forEach(printAfterDelay());
        long end = System.nanoTime();
        return String.format("time: %ssec", (end - start) / 1e9);
    }

    public static String sumSequential(long max) {
        long start = System.nanoTime();
        long sum = LongStream.rangeClosed(1, max).sum();
        long end = System.nanoTime();
        return String.format("time: %ssec", (end - start) / 1e9);
    }

    public static String sumParallel(long max) {
        long start = System.nanoTime();
        long sum = LongStream.rangeClosed(1, max).parallel().sum();
        long end = System.nanoTime();
        return String.format("time: %ssec", (end - start) / 1e9);
    }

    public static void main(String[] args) {
        System.out.println("--- Sequential Print ---");
        System.out.println(printSequential(8));
        System.out.println("--- Parallel Print ---");
        System.out.println(printParallel(8));

        System.out.println("\n--- Sequential Sum ---");
        System.out.println(sumSequential(1_000_000));
        System.out.println("---  Parallel Sum ---");
        System.out.println(sumParallel(1_000_000));
    }
}
