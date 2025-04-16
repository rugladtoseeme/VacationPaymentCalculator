package com.example.vacation_payment_calculator.controller;

import com.example.vacation_payment_calculator.dto.VacationPaymentRequest;
import com.example.vacation_payment_calculator.service.VacationPaymentCalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/vacation-payment-calculator")
public class VacationPaymentCalculatorController {

    private final VacationPaymentCalculatorService service;

    @Autowired
    public VacationPaymentCalculatorController(VacationPaymentCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public Double calculate(@Valid @RequestBody VacationPaymentRequest request) {
        return service.calculate(request.getVacationDays(), request.getAverageSalary(), request.getStartDate());
    }

}