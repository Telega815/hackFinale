package ru.icerebro.hackFinale.services.interfaces;

import ru.icerebro.hackFinale.entities.Answer;
import ru.icerebro.hackFinale.entities.Question;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

public interface VoteService {
    List<Vote> getVotes(int votecategory);

    List<Question> getQuestion(Integer vote);

    List<Answer> getAnswers(Question q);
}
