package com.perscholas.twistntreats.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @GetMapping("/admin/index")
    public ModelAndView index() {
        log.debug("Admin index page requested");
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/index");
        return response;
    }

}