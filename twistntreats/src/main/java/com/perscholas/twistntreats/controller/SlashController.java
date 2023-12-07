package com.perscholas.twistntreats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SlashController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        return response;
    }
    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView response = new ModelAndView("about");
        return response;
    }
}
