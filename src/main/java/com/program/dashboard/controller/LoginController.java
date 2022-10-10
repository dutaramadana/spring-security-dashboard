package com.program.dashboard.controller;


import com.program.dashboard.entity.Customer;
import com.program.dashboard.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @Autowired
    private CustomerService customerService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model){

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return  "dashboard";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }

}
