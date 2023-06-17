package java_learning.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class find_out {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        LocalDate starting = ld.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        for(int i = 0; i < 2; i++)
        {
            starting = starting.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        System.out.println("You will end on: " + starting);
    }
}
