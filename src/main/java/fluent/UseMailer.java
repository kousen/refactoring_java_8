package fluent;


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
                    .subject("Your code is better now")
                    .body("¯\\_(ツ)_/¯");
        });
    }
}
