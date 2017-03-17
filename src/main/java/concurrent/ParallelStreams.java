package concurrent;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
    private static IntConsumer printAfterDelay() {
        return n -> {
            try {
                Thread.sleep(100);
                System.out.println(n + " " + Thread.currentThread().getName());
            } catch (InterruptedException ignored) {
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

    public static String sumStreamLong(long max) {
        long start = System.nanoTime();
        //long sum = LongStream.rangeClosed(1, max).sum();
        Long sum = Stream.iterate(1L, n -> n + 1L)
                .limit(max)
                .reduce(0L, (acc, n) -> acc + n);
        long end = System.nanoTime();
        return String.format("time: %ssec", (end - start) / 1e9);
    }

    public static String sumStreamLongParallel(long max) {
        long start = System.nanoTime();
        //long sum = LongStream.rangeClosed(1, max).sum();
        Long sum = Stream.iterate(1L, n -> n + 1L)
                .parallel()
                .limit(max)
                .reduce(0L, (acc, n) -> acc + n);
        long end = System.nanoTime();
        return String.format("time: %ssec", (end - start) / 1e9);
    }

    public static void main(String[] args) {
        System.out.println("--- Sequential Print ---");
        System.out.println(printSequential(8));
        System.out.println("--- Parallel Print ---");
        System.out.println(printParallel(8));
        System.out.println("--- Sequential LongStream ---");
        System.out.println(sumSequential(10_000_000));
        System.out.println("--- Sequential Stream<Long> ---");
        System.out.println(sumStreamLong(10_000_000));
        System.out.println("--- Parallel Stream<Long> ---");
        System.out.println(sumStreamLong(10_000_000));
        System.out.println("--- Parallel LongStream ---");
        System.out.println(sumParallel(10_000_000));
    }
}
