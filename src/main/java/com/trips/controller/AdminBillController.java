package com.trips.controller;

import com.trips.entity.Bill;
import com.trips.service.BookingTicketService;
import com.trips.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Khanh Nguyen on 29/5/2017.
 */
@RequestMapping("/admin/bill")
@Controller
public class AdminBillController {

    @Autowired
    BookingTicketService bookingTicketService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") String page) {
        int currentPage = 1;
        String redirectUrl = "redirect:/admin/bill/list?page=1";
        try {
            currentPage = Integer.parseInt(page);
        } catch (Exception e) {
            return redirectUrl;
        }
        if (currentPage <= 0) {
            return redirectUrl;
        }
        PaginationUtil<Bill> paging = bookingTicketService.paging(currentPage);
        if (!paging.isFound()) {
            return redirectUrl;
        } else {
            model.addAttribute("paging", paging);
            return "admin/bill/list";
        }
    }


}
