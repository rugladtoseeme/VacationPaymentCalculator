package com.example.vacation_payment_calculator.service;

import com.example.vacation_payment_calculator.calendar.HolidayChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VacationPaymentCalculatorServiceTest {

    private VacationPaymentCalculatorService  calcService;

    @Test
    void calculate() {

        Double expectedResult = 80000.;
        LocalDate testDate = LocalDate.of(2024,4,7);
        Double actualResult = calcService.calculate(11,293000., LocalDate.of(2024,4,7));
        assertEquals(expectedResult, actualResult);
    }

    @BeforeEach
    public void init() {
        HolidayChecker holidayChecker = new HolidayChecker();
        calcService = new VacationPaymentCalculatorService(holidayChecker);
    }

}