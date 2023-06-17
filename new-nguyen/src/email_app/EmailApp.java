package email_app;

public class EmailApp {
    public static void main(String []args)
    {
        Email em1 = new Email("Nguyen", "Nguyen");
        em1.setAlternativeEmail("ducnguyenbernardine@gmail.com");
        System.out.println(em1.show_info());
    }
}
