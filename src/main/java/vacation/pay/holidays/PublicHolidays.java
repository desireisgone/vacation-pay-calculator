package vacation.pay.holidays;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@UtilityClass
public class PublicHolidays {
    private static final int currentYear = LocalDate.now().getYear();

    public static final List<LocalDate> holidays = List.of(
            LocalDate.of(currentYear, Month.JANUARY, 1),    // Новогодние каникулы (1-6, 8)
            LocalDate.of(currentYear, Month.JANUARY, 2),
            LocalDate.of(currentYear, Month.JANUARY, 3),
            LocalDate.of(currentYear, Month.JANUARY, 4),
            LocalDate.of(currentYear, Month.JANUARY, 5),
            LocalDate.of(currentYear, Month.JANUARY, 6),
            LocalDate.of(currentYear, Month.JANUARY, 7),    // Рождество
            LocalDate.of(currentYear, Month.JANUARY, 8),    // Новогодние каникулы (1-6, 8)
            LocalDate.of(currentYear, Month.FEBRUARY, 23),  // День защитника Отечества
            LocalDate.of(currentYear, Month.MARCH, 8),      // Международный женский день
            LocalDate.of(currentYear, Month.MAY, 1),        // Праздник Весны и Труда
            LocalDate.of(currentYear, Month.MAY, 9),        // День Победы
            LocalDate.of(currentYear, Month.JUNE, 12),      // День России
            LocalDate.of(currentYear, Month.NOVEMBER, 4)    // День народного единства
    );
}
