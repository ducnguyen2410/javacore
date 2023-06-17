package ex3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        String soDT;
        String lenh;
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String cuPhapNumber;
        dateTime = LocalDateTime.parse("20-10-2003 10:23:12", dt);
        System.out.println(dateTime);
    }
}
