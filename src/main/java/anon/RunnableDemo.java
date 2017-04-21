package anon;

public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable with an anonymous inner class");
            }
        }).start();

        new Thread(() -> System.out.println("Inside Runnable with a lambda expression")).start();
    }
}
