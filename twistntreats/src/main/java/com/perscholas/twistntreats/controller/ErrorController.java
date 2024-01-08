package com.perscholas.twistntreats.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @RequestMapping(value = "/error/404")
    public String error404(HttpServletRequest request) {
        // This is used in the security config for 404 pages
        log.info("endpoint:/error/404 - Requested URL not found : " + request.getRequestURL());

        return "error/404";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView accessDenied(HttpServletRequest request, Exception ex) {
        ModelAndView response = new ModelAndView("error/404");

        log.warn("User requested url that they do not have permission to " + request.getRequestURL());

        return response;
    }
    @RequestMapping(value="/?error")
    public String loginPage(HttpServletRequest request) {

            log.info("Invalid username or password");
            log.warn("Invalid username or password");

        return "error";
    }

}