package com.trips.controller;

import com.trips.entity.Bill;
import com.trips.entity.WeekSchedule;
import com.trips.service.BookingTicketService;
import com.trips.service.WeekScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookingTicketController {

    @Autowired
    WeekScheduleService weekScheduleService;

    @Autowired
    BookingTicketService bookingTicketService;

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
            int routeId = weekSchedule.getRoute().getRouteId();
            model.addAttribute("stationList", bookingTicketService.getStationList(routeId));
            model.addAttribute("stopPointList", bookingTicketService.getStopPointList(routeId));
            return "main/bookingTicket";
        }
    }

    @GetMapping("/booking-ticket-processing")
    public String process(RedirectAttributes redirectAttributes,
                          @RequestParam("ws") String ws,
                          @RequestParam("name") String name,
                          @RequestParam("phoneNumber") String phoneNumber,
                          @RequestParam("cusStartPoint") String cusStartPoint,
                          @RequestParam("cusEndPoint") String cusEndPoint,
                          @RequestParam("stationIdFirst") String stationIdFirst,
                          @RequestParam("stationIdLast") String stationIdLast,
                          @RequestParam("seatType") String seatType) {
        String redirectUrl = "redirect:/";
        try {
            int stationFirst = Integer.parseInt(stationIdFirst);
            int stationLast = Integer.parseInt(stationIdLast);
            int type = Integer.parseInt(seatType);
            int wsId = Integer.parseInt(ws);
            Bill bill = bookingTicketService.booking(wsId, name, phoneNumber, cusStartPoint, cusEndPoint, stationFirst, stationLast, type);
            redirectAttributes.addFlashAttribute("bill", bill);
            return "redirect:/booking-success";
        } catch (Exception e) {

        }
        return redirectUrl;
    }

    @GetMapping("/booking-success")
    public String success() {
        return "main/bookingSuccess";
    }

}
