package com.example.vacation_payment_calculator.controller;

import com.example.vacation_payment_calculator.service.VacationPaymentCalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Validated
//@ResponseBody
@RequestMapping("/vacation-payment-calculator")
public class VacationPaymentCalculatorController {

    @Autowired
    private VacationPaymentCalculatorService service;

    @GetMapping("/calculate")
    public Double calculate(@Valid @RequestParam Integer days, @Valid @RequestParam Double averageSalary, @RequestParam LocalDate startDate) {
        return service.calculate(days, averageSalary, startDate);
    }

}