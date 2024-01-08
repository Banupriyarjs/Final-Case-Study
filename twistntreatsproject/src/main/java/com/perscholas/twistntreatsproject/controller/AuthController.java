package com.perscholas.twistntreatsproject.controller;

import com.perscholas.twistntreatsproject.database.entity.User;
import com.perscholas.twistntreatsproject.formbean.RegisterUserFormBean;
import com.perscholas.twistntreatsproject.security.AuthenticatedUserService;
import com.perscholas.twistntreatsproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/auth/login")
    public ModelAndView login()
    {
        ModelAndView response=new ModelAndView();
        response.setViewName("auth/login");
        return response;
    }
    @GetMapping("/auth/register")
    public ModelAndView register()
    {
        ModelAndView response=new ModelAndView();
        response.setViewName("auth/register");
        return response;
    }
    @GetMapping("/auth/registerSubmit")
    public ModelAndView registerSubmit(@Valid RegisterUserFormBean form, BindingResult bindingResult, HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            log.info("######################### In register user - has errors #########################");
            ModelAndView response =new ModelAndView("auth/register");

            for(ObjectError error:bindingResult.getAllErrors())
            {
                log.info("error: "+error.getDefaultMessage());
            }
            response.addObject("form",form);
            response.addObject("errors",bindingResult);
            return response;

        }
        log.info("######################### In register user - no error found #########################");
         User u=userService.createNewUser(form);
         authenticatedUserService.authenticateNewUser(session,u.getEmail(),u.getPassword());
         ModelAndView response=new ModelAndView();
         response.setViewName("redirect:/");
         return response;
    }

}
