package ru.icerebro.hackFinale.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.icerebro.hackFinale.dao.interfaces.AnswerDAO;
import ru.icerebro.hackFinale.dao.interfaces.QuestionDAO;
import ru.icerebro.hackFinale.dao.interfaces.VoteDAO;
import ru.icerebro.hackFinale.entities.Answer;
import ru.icerebro.hackFinale.entities.Question;
import ru.icerebro.hackFinale.entities.Vote;
import ru.icerebro.hackFinale.services.interfaces.VoteService;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteDAO voteDAO;

    private final QuestionDAO questionDAO;

    private final AnswerDAO answerDAO;

    @Autowired
    public VoteServiceImpl(VoteDAO voteDAO, QuestionDAO questionDAO, AnswerDAO answerDAO) {
        this.voteDAO = voteDAO;
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;
    }

    @Override
    public List<Vote> getVotes(int votecategory) {
        return voteDAO.getVotes(votecategory);
    }

    @Override
    public List<Question> getQuestion(Integer vote) {
        Vote vote1 = voteDAO.getVote(vote);
        return questionDAO.getQuestions(vote1);
    }

    @Override
    public List<Answer> getAnswers(Question q) {
        return answerDAO.getAnswers(q);
    }
}
