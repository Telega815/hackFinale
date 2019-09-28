package ru.icerebro.hackFinale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Vote;
import ru.icerebro.hackFinale.services.interfaces.UserService;
import ru.icerebro.hackFinale.services.interfaces.VoteService;

import java.util.List;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    private final VoteService voteService;

    @Autowired
    public MainController(UserService userService, VoteService voteService) {
        this.userService = userService;
        this.voteService = voteService;
    }

    @GetMapping(value = "/")
    public ModelAndView welcomePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vote");

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

    @GetMapping(value = "/mainpage")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");

        return modelAndView;
    }

    @GetMapping(value = "/Category")
    public ModelAndView toCategory(@RequestParam(value = "votecategory") Integer votecategory){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listOfCategory");

        List<Vote> votes = voteService.getVotes(votecategory);

        modelAndView.addObject("votes", votes);
        return modelAndView;
    }
}
