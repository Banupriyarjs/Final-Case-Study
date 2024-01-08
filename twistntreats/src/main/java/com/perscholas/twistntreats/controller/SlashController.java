package com.perscholas.twistntreats.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class SlashController {
    @GetMapping("/")
    public ModelAndView index() {
        log.info("*************Slash Controller");
        ModelAndView response = new ModelAndView("index");
        return response;
    }
    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView response = new ModelAndView("about");
        return response;
    }
}
