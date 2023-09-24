package com.testharness;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTest {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();

        LocalDate firstMonday = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.THURSDAY));
        LocalDate lastMonday = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));

        System.out.println(firstMonday.getDayOfMonth());
        System.out.println(lastMonday.getDayOfMonth());

    }
}
