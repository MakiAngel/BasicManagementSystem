package com.uestc.fff.information.controller;

import com.uestc.fff.information.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/host")
public class HostController {
//    @Autowired
//    private HostService serviceHost;

    @RequestMapping("/main")
    public String hostPages(Model model){
        String test;
        test = "hello";
        model.addAttribute("tests",test);
        return "host";
    }
}
