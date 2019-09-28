package ru.icerebro.hackFinale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icerebro.hackFinale.JSON.JsonVote;
import ru.icerebro.hackFinale.JSON.JsonVoteList;
import ru.icerebro.hackFinale.entities.User;
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
    public JsonVoteList restorePost(HttpSession session,
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

}
