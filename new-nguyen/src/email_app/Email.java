package email_app;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private String school;
    private int mailboxCapacity;
    private String alternativeEmail;
    private int defaultPasswordLength;
    private String emailsuffix = "edu.com";
    public Email(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);
        this.school = setSchool();
        this.password = randomPassword(8);
        this.email = this.firstName.toLowerCase() + this.lastName.toLowerCase() + "@" + this.school + "." + this.emailsuffix;
        System.out.println("Your email is: " + this.email);
    }

    private String setSchool()
    {
        System.out.print("Enter the school name: ");
        Scanner in = new Scanner(System.in);
        String sc = in.nextLine();
        System.out.println("Your school is: " + sc);
        return sc;
    }

    private String randomPassword(int length)
    {
        String passwordset = "ABCDEFGHIKLMNOPJQW123456789!@#$%^&*";
        char []password = new char[length];
        for(int i = 0; i < length; i++)
        {
            int rand = (int)(Math.random() * passwordset.length());
            password[i] = passwordset.charAt(rand);
        }
        String temp = new String(password);
        System.out.println("Your random Password is: " + temp);
        return temp;
    }

    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }

    public void setAlternativeEmail(String altEmail)
    {
        this.alternativeEmail = altEmail;
    }

    public void changePassword(String new_password)
    {
        this.password = new_password;
    }

    public int getMailboxCapacity()
    {
        return this.mailboxCapacity;
    }

    public String getAlternativeEmail()
    {
        return this.alternativeEmail;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String show_info()
    {
        return "DISPLAY NAME: "+ firstName + " " + lastName + "\n"+
                "SCHOOl EMAIL: " + email + "\n" +
                "MAILBOX CAPACITY: " + mailboxCapacity + " mb";
    }
}
