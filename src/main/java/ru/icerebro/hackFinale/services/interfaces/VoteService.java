package ru.icerebro.hackFinale.services.interfaces;

import ru.icerebro.hackFinale.JSON.JsonVoteResList;
import ru.icerebro.hackFinale.entities.*;

import java.util.List;

public interface VoteService {
    List<Vote> getVotes(int votecategory);

    List<Question> getQuestion(Integer vote);

    List<Answer> getAnswers(Question q);

    JsonVoteResList voteNow(User loggedInUser, Integer qId, Integer answ);

    Userwatched isAnswered(User loggedUser, Question question);

    List<Userwatched> isAnswered(User loggedUser);
}
