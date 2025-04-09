package com.example.vacation_payment_calculator.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class VacationPaymentRequest {
    @Positive(message = "Зарплата должна быть положительной")
    private double averageSalary;

    @Positive(message = "Количество дней должно быть положительным")
    private int vacationDays;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Positive(message = "Зарплата должна быть положительной")
    public double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(@Positive(message = "Зарплата должна быть положительной") double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Positive(message = "Количество дней должно быть положительным")
    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(@Positive(message = "Количество дней должно быть положительным") int vacationDays) {
        this.vacationDays = vacationDays;
    }

}