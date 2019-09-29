package ru.icerebro.hackFinale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.icerebro.hackFinale.entities.*;
import ru.icerebro.hackFinale.services.interfaces.UserService;
import ru.icerebro.hackFinale.services.interfaces.VoteService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MainController {

    private final UserService userService;

    private final VoteService voteService;

    @Autowired
    public MainController(UserService userService, VoteService voteService) {
        this.userService = userService;
        this.voteService = voteService;
    }

    @GetMapping(value = "/")
    public ModelAndView welcomePage(HttpServletRequest request,
                                    ModelMap model) {


        User loggedUser = null;
        if (request.getUserPrincipal() != null)
            loggedUser = userService.getUser(request.getUserPrincipal().getName());

        if (loggedUser != null){
            return new ModelAndView("redirect:/mainpage", model);
        }


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

    @GetMapping(value = "/mainpage")
    public ModelAndView mainPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");

        User loggedUser = null;
        if (request.getUserPrincipal() != null)
            loggedUser = userService.getUser(request.getUserPrincipal().getName());

        List<Userwatched> list = voteService.isAnswered(loggedUser);

        list.sort((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));

        modelAndView.addObject("watchedList", list);

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

    @GetMapping(value = "/Vote")
    public ModelAndView toVote(@RequestParam(value = "vote") Integer vote,
                               HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vote");

        List<Question> questions = voteService.getQuestion(vote);

        questions.sort((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));

        modelAndView.addObject("questions", questions);

        Map<Integer, List<Answer>> map = new HashMap<>();

        User loggedUser = userService.getUser(request.getUserPrincipal().getName());

        List<Userwatched> list = new ArrayList<>();

        Map<Integer, Integer> voteMap = new HashMap<>();

        for (Question q:questions) {
            Userwatched userwatched = voteService.isAnswered(loggedUser, q);

            if (userwatched != null)
                list.add(userwatched);
            List<Answer> answers = voteService.getAnswers(q);


            answers.sort(Comparator.comparingInt(Answer::getId));
            map.put(q.getId(), answers);

            Integer aSum = 0;
            for (Answer answer: answers) {
                aSum+=answer.getVotecount();
            }
            voteMap.put(q.getId(), aSum);
        }

        modelAndView.addObject("wached", list);
        modelAndView.addObject("answ", map);
        modelAndView.addObject("voteMap", voteMap);


        return modelAndView;
    }
}
