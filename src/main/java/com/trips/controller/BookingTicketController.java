package com.trips.controller;

import com.trips.entity.WeekSchedule;
import com.trips.service.WeekScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingTicketController {

    @Autowired
    WeekScheduleService weekScheduleService;

    @GetMapping("/booking-ticket")
    public String booking(Model model, @RequestParam(value = "ws", defaultValue = "1") String ws) {
        String redirectUrl = "redirect:/booking-ticket?ws=1";
        int wsId = 1;
        try {
            wsId = Integer.parseInt(ws);
        } catch (Exception e) {
            return redirectUrl;
        }
        WeekSchedule weekSchedule = weekScheduleService.getWeekScheduleId(wsId);
        if (weekSchedule == null) {
            return redirectUrl;
        } else {
            model.addAttribute("weekSchedule", weekSchedule);
            return "main/bookingTicket";
        }
    }

}
