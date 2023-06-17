package java_learning.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class date_time {
    public static void main(String[] args) {
        date_time test_date = new date_time();
        test_date.testlocalDateTime();
    }

    public void testlocalDateTime()
    {
        LocalDateTime current = LocalDateTime.now();
        System.out.println("The local date time is now: " + current);

        LocalDate localdate = current.toLocalDate();
        System.out.println("The local date is now: " + localdate);

        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int second = current.getSecond();
        int hour = current.getHour();
        System.out.println("Month: " + month + " Day: " + day + " Second: " + second + " Hour: " + hour);

        LocalDateTime d2 = current.withMonth(8).withDayOfMonth(12).withYear(2023);
        System.out.println("d2: " + d2);

        LocalTime d3 = LocalTime.parse("20:15:33");
        System.out.println("d3: " + d3);

    }
}
