package java_learning.datetime;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class zoned_date {
    public static void main(String[] args) {
        zoned_date test_zone = new zoned_date();
        test_zone.testZonedDateTime();
    }

    public void testZonedDateTime()
    {
        ZonedDateTime z1 = ZonedDateTime.now();
        System.out.println("z1: "+ z1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("Id: " + id);

        ZoneId cur_id = ZoneId.systemDefault();
        System.out.println("Currentzone: " + cur_id);

        LocalDate ld = LocalDate.now();
        LocalDate next_week = ld.with(TemporalAdjusters.next(ld.getDayOfWeek()));
        System.out.println("Next week this time will be: " + next_week);
        System.out.println("And it will be on: " + next_week.getDayOfWeek());

        LocalDate next_month = ld.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(next_month);
        //Get the 2nd Saturday of next month
        LocalDate firstinyear = LocalDate.of(next_month.getYear(), next_month.getMonthValue(), 1);
        LocalDate second_saturday_nextweek = firstinyear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("The second Saturday of next week will be on: "+ second_saturday_nextweek);
    }
}
