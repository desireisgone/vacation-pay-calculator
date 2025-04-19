package vacation.pay.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vacation.pay.services.VacationPayService;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class VacationPayController {
    private final VacationPayService vacationPayService;

    @GetMapping
    public double calculateVacationPay(
            @RequestParam("avg_salary") double avgSalary,
            @RequestParam("vac_len") int vacationLen,
            @RequestParam(name = "vac_start_day", required = false)
            @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate vacationStartDay) {
        return vacationPayService.calculateVacationPay(avgSalary, vacationLen, vacationStartDay);
    }
}
