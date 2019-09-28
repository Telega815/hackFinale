package ru.icerebro.hackFinale.dao.interfaces;

import ru.icerebro.hackFinale.entities.Question;
import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

public interface QuestionDAO {
    List<Question> getQuestions(Vote vote);
    int saveQuestions(Question qpicture);
    void deleteQuestions(Question qpicture);
    void updateQuestions(Question qpicture);

    Question getQuestions(Integer qId);
}
