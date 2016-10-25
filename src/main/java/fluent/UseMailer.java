package fluent;

/**
 * Created by Ken Kousen on 10/14/16.
 */

//public class UseMailer {
//  public static void main(String[] args) {
//    Mailer mailer = new Mailer();
//    mailer.from("builder@agiledeveloper.com");
//    mailer.to("venkats@agiledeveloper.com");
//    mailer.subject("Your code sucks");
//    mailer.body("...");
//    mailer.send();
//  }
//}

public class UseMailer {
    public static void main(String[] args) {
        Mailer.send(mailer -> {
            mailer.from("builder@agiledeveloper.com")
                    .to("venkats@agiledeveloper.com")
                    .subject("Your code sucks")
                    .body("¯\\_(ツ)_/¯");
        });
    }
}
