package com.example.vacation_payment_calculator.service;

import com.example.vacation_payment_calculator.calendar.HolidayChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VacationPaymentCalculatorService {

    private static final Double averageDaysInMonth = 29.3;

    private HolidayChecker holidayChecker;

    @Autowired
    public VacationPaymentCalculatorService(HolidayChecker holidayChecker) {
        this.holidayChecker = holidayChecker;
    }

    public Double calculate(Integer days, Double averageSalary, LocalDate startDate) {

        int workingDays = 0;
        LocalDate currentDate = startDate;

        for (int i = 0; i < days; i++) {
            if (!holidayChecker.isHoliday(currentDate)) {
                workingDays++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return (averageSalary / averageDaysInMonth) * workingDays;
    }

}
