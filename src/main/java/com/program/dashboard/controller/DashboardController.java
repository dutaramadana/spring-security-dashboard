package com.program.dashboard.controller;


import com.program.dashboard.entity.Customer;
import com.program.dashboard.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {




    @GetMapping("/addData")
    public String showAddData(){
        return "add-data";
    }

}
