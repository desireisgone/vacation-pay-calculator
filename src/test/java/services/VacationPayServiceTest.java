package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import vacation.pay.exceptions.ParamValidationException;
import vacation.pay.services.VacationPayService;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

public class VacationPayServiceTest {
    private final VacationPayService vacationPayService = new VacationPayService();

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(50000, 10, null, 17064.846),
                Arguments.of(43567.543, 10, null, 14869.469),
                Arguments.of(50000, 10, LocalDate.of(2025, Month.APRIL, 30), 13651.877),
                Arguments.of(43567.543, 10, LocalDate.of(2025, Month.APRIL, 30), 11895.575)
        );
    }

    @Test
    public void givenNegativeAvgSalary_thenThrowException() {
        Assertions.assertThrows(ParamValidationException.class, () ->
                vacationPayService.calculateVacationPay(-50000, 10, null));
    }

    @Test
    public void givenNegativeVacationLen_thenThrowException() {
        Assertions.assertThrows(ParamValidationException.class, () ->
                vacationPayService.calculateVacationPay(50000, -10, null));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void givenCorrectInputs_thenCorrectResult(double avgSalary, int vacationLen,
                                                     LocalDate vacationStartDay, double result) {
        Assertions.assertEquals(
                result,
                vacationPayService.calculateVacationPay(avgSalary, vacationLen, vacationStartDay),
                0.001
        );
    }
}
