package com.example.vacation_payment_calculator.service;

import com.example.vacation_payment_calculator.calendar.HolidayChecker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VacationPaymentCalculatorServiceTest {

    private static VacationPaymentCalculatorService  calcService;

    @Test
    void calculate() {
        Double expectedResult = 80000.;
        Double actualResult = calcService.calculate(11,293000., LocalDate.of(2024,4,7));
        assertEquals(expectedResult, actualResult);
    }

    @BeforeAll
    public static void init() {
        calcService = new VacationPaymentCalculatorService(new HolidayChecker());
    }

}