package ru.icerebro.hackFinale.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Vote;
import ru.icerebro.hackFinale.services.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

public class JsonVoteList {
    List<JsonVote> voteList;

    @Autowired
    private UserService userService;

    public JsonVoteList(User user, List<Vote> votes) {
        voteList = new ArrayList<>();

        for (Vote vote: votes) {
            voteList.add(new JsonVote(userService.isWatched(user, vote), vote));
        }
    }
}
