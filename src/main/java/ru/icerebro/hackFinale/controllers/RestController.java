package ru.icerebro.hackFinale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icerebro.hackFinale.JSON.JsonVote;
import ru.icerebro.hackFinale.JSON.JsonVoteList;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.UserLikes;
import ru.icerebro.hackFinale.services.interfaces.UserService;
import ru.icerebro.hackFinale.services.interfaces.VoteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class RestController {

    private final UserService userService;

    private final VoteService voteService;

    @Autowired
    public RestController(UserService userService, VoteService voteService) {
        this.userService = userService;
        this.voteService = voteService;
    }


    @GetMapping(value = "/restService/getVotes")
    @ResponseBody
    public JsonVoteList getVotes(HttpSession session,
                                @RequestParam(value = "votecategory") Integer votecategory,
                                HttpServletRequest request,
                                HttpServletResponse response){

        String userName;

        if (request.getUserPrincipal() != null){
            userName = request.getUserPrincipal().getName();
            User loggedInUser = userService.getUser(userName);
            return new JsonVoteList(loggedInUser, voteService.getVotes(votecategory));
        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
    }

    @GetMapping(value = "/restService/toggleHeart")
    @ResponseBody
    public int toggleHeart(HttpSession session,
                                    @RequestParam(value = "heart") Integer heart,
                                    HttpServletRequest request,
                                    HttpServletResponse response){

        String userName;

        if (request.getUserPrincipal() != null){
            userName = request.getUserPrincipal().getName();
            User loggedInUser = userService.getUser(userName);
            UserLikes userLikes = userService.toggleHeart(loggedInUser, heart);
            if (userLikes == null)
                return 0;
            else
                return 1;
        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }
    }

    @GetMapping(value = "/restService/VoteNow")
    @ResponseBody
    public int toggleHeart(HttpSession session,
                           @RequestParam(value = "qId") Integer qId,
                           @RequestParam(value = "answ") Integer answ,
                           HttpServletRequest request,
                           HttpServletResponse response){

        String userName;

        if (request.getUserPrincipal() != null){
            userName = request.getUserPrincipal().getName();
            User loggedInUser = userService.getUser(userName);
            voteService.voteNow(loggedInUser, qId, answ);
            return 0;
        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return -1;
        }
    }
}
