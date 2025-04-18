package com.example.vacation_payment_calculator.calendar;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class HolidayChecker {

    public boolean isHoliday(LocalDate date) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://isdayoff.ru/" + date.format(DateTimeFormatter.ofPattern("yyyyMMdd"))))
                .GET()
                .build();

        String result;
        HttpClient client = HttpClient.newBuilder().build();

        try {
            result = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "1".equals(result);  // 1 -нерабочий день, 0 - рабочий день
    }
}
