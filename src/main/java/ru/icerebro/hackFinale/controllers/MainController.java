package ru.icerebro.hackFinale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.services.interfaces.UserService;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView welcomePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome_page");

        User user = new User();
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping(value = "/service/registration")
    public ModelAndView registrationPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");

        User user = new User();
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PostMapping(value = "/service/registration")
    public String registrationPost(@ModelAttribute("user") User user) {

        userService.createUser(user);

        return "redirect:/";
    }

//    @GetMapping(value = "/service/goToUserPage")
//    public ModelAndView mainPage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("main_page");
//
//        return modelAndView;
//    }
}
