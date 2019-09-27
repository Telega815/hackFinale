package ru.icerebro.hackFinale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public ModelAndView welcomePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome_page");

        return modelAndView;
    }
}
