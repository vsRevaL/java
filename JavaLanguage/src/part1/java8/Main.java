package part1.java8;

import java.time.*;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        //Calendar calendar = Calendar.getInstance(); // OLD
        //calendar.get(Calendar.YEAR);

        LocalDate.now();
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2014, 2, 17));
        System.out.println(LocalDate.ofYearDay(2014, 65));

        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        System.out.println(LocalTime.now(ZoneId.of("America/New_York")));
        System.out.println(LocalTime.now(Clock.systemUTC()));

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}