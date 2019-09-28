package ru.icerebro.hackFinale.dao.interfaces;

import ru.icerebro.hackFinale.entities.Answer;
import ru.icerebro.hackFinale.entities.Question;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAnswers(Question question);
    int saveAnswer(Answer answer);
    void deleteAnswer(Answer answer);
    void updateAnswer(Answer answer);

    Answer getAnswers(Integer answ);
}
