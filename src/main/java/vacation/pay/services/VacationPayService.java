package vacation.pay.services;

import org.springframework.stereotype.Service;
import vacation.pay.exceptions.ParamValidationException;
import vacation.pay.holidays.PublicHolidays;

import java.time.LocalDate;

@Service
public class VacationPayService {
    private static final float AVG_DAYS_IN_MONTH = 29.3f;

    public double calculateVacationPay(double avgSalary, int vacationLen, LocalDate vacationStartDay) {
        validateParams(avgSalary, vacationLen);

        int paidVacationDays = (vacationStartDay != null)
                ? calculatePaidVacationDays(vacationStartDay, vacationLen)
                : vacationLen;

        return avgSalary / AVG_DAYS_IN_MONTH * paidVacationDays;
    }

    private void validateParams(double avgSalary, int vacationLen) {
        if (avgSalary < 0 || vacationLen <= 0) {
            throw new ParamValidationException();
        }
    }

    private int calculatePaidVacationDays(LocalDate start, int len) {
        LocalDate finish = start.plusDays(len);
        return len - (int) PublicHolidays.holidays.stream()
                .filter(h -> h.isEqual(start) || h.isAfter(start) && h.isBefore(finish))
                .count();
    }
}
