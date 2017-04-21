package eam.after;

public class UseResource {
    public static void main(String[] args) {
//        Resource r = new Resource();
//        try {
//            r.op1();
//            r.op2();
//        } finally {
//            r.close();
//        }

        Resource.use(r -> {
            r.op1();
            r.op2();
        });

        Resource.use(Resource.op1op2);
    }
}
