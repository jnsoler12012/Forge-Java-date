package com.nicolas.fecha.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DateController {
    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public String date(Model model) {
        LocalDate localDate = LocalDate.now();

        String dayString = StringUtils.capitalize(localDate.getDayOfWeek().toString().toLowerCase());
        String dayInt = Integer.toString(localDate.getDayOfMonth());
        String monthString = StringUtils.capitalize(localDate.getMonth().toString().toLowerCase());
        String yearInt = Integer.toString(localDate.getYear());

        System.out.println(yearInt);

        String finalString = dayString + ", the " + dayInt + " of " + monthString + ", " + yearInt;

        model.addAttribute("stringDate", finalString);

        return "date";
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String time(Model model) {

        LocalDateTime localDate = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("hh:mm a");

        model.addAttribute("stringTime", dateTimeFormatter.format(localDate));

        return "time";
    }
}
