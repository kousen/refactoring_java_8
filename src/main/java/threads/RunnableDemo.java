package threads;

/**
 * Created by Ken Kousen on 10/14/16.
 */
public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running using anon inner class...");
            }
        }).start();

        new Thread(() -> System.out.println(
                "Running using lambda...")).start();
    }
}
