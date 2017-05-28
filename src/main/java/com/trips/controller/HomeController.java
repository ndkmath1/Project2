package com.trips.controller;

import com.trips.service.RouteService;
import com.trips.service.WeekScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.util.DateTimeUtil;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class HomeController {

	@Autowired
	WeekScheduleService weekScheduleService;

	@Autowired
	RouteService routeService;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("nextDate", DateTimeUtil.getNextDate());
		model.addAttribute("routeList", routeService.getRouteList());
		return "main/home";
	}

	@GetMapping("/search-schedule")
	public String search(Model model, @RequestParam("routeId") String routeId, @RequestParam("selectDate") String date, RedirectAttributes redirectAttributes) {
		System.out.println("routeId: " + routeId);
		System.out.println("date: " + date);
		String homeUrl = "/";
		try {
			int rId = Integer.parseInt(routeId);
			Date d = DateTimeUtil.stringToDate(date);
//			redirectAttributes.addAttribute("resultList", weekScheduleService.findWeekSchedule(rId, d));
//			return "redirect:/search-result";
			model.addAttribute("resultList", weekScheduleService.findWeekSchedule(rId, d));
			return "main/searchResult";
		} catch (Exception e) {
			return homeUrl;
		}
	}

//	@GetMapping("/search-result")
//	public String searchResult() {
//		return "main/searchResult";
//	}
	
}
