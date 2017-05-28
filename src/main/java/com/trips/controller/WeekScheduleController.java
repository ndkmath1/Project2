package com.trips.controller;

import com.trips.dao.WeekScheduleDao;
import com.trips.entity.WeekSchedule;
import com.trips.service.WeekScheduleService;
import com.trips.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Khanh Nguyen on 28/5/2017.
 */
@Controller
@RequestMapping("/week-schedule")
public class WeekScheduleController {

    @Autowired
    WeekScheduleService weekScheduleService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("map", weekScheduleService.getWeekSchedule());
        return "main/weekSchedule";
    }

}
