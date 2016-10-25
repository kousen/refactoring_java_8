package fluent;

import java.util.function.Consumer;

/**
 * Created by Ken Kousen on 10/14/16.
 */

// Note: borrowed from Venkat with some modifications

//class Mailer {
//  public void from(String addr) { System.out.println("from"); }
//  public void to(String addr) { System.out.println("to"); }
//  public void subject(String subjectLine) { System.out.println("subject"); }
//  public void body(String message) { System.out.println("body"); }
//  public void send() { System.out.println("sending..."); }
//}
public class Mailer {
    private String from;
    private String to;
    private String subject;
    private String body;

    public Mailer from(String from) {
        this.from = from;
        return this;
    }

    public Mailer to(String to) {
        this.to = to;
        return this;
    }

    public Mailer subject(String subject) {
        this.subject = subject;
        return this;
    }

    public Mailer body(String message) {
        this.body = message;
        return this;
    }

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("sending...\n" + mailer);
    }

    public String toString() {
        return  String.format("From   : %s\n", from) +
                String.format("To     : %s\n", to) +
                String.format("Subject: %s\n", subject) +
                String.format("Message: %s", body);
    }
}
