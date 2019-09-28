package ru.icerebro.hackFinale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.icerebro.hackFinale.entities.Answer;
import ru.icerebro.hackFinale.entities.Question;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Vote;
import ru.icerebro.hackFinale.services.interfaces.UserService;
import ru.icerebro.hackFinale.services.interfaces.VoteService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/mainpage")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");

//        List<UserLikes> list = userService.getUserLikes(request.getUserPrincipal().getName());
//
//        List<String> strings = new ArrayList<String>(4);
//
//        list.sort((o1, o2) -> {
//            if (o1.getVotecategory() < o2.getVotecategory())
//                return -1;
//            else if (Objects.equals(o1.getVotecategory(), o2.getVotecategory()))
//                return 0;
//            else
//                return 1;
//        });
//        for (UserLikes like: list) {
//            if (like.getLike())
//                strings.add("like_close");
//            else
//                strings.add("like_open");
//        }
//
//        modelAndView.addObject("likes", strings);

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
    public ModelAndView toVote(@RequestParam(value = "vote") Integer vote){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vote");

        List<Question> questions = voteService.getQuestion(vote);

        questions.sort((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));

        modelAndView.addObject("questions", questions);

        Map<Integer, List<Answer>> map = new HashMap<>();

        for (Question q:questions) {
            List<Answer> answers = voteService.getAnswers(q);

            answers.sort(Comparator.comparingInt(Answer::getId));

            map.put(q.getId(), answers);
        }

        modelAndView.addObject("answ", map);

        return modelAndView;
    }
}
