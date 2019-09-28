package ru.icerebro.hackFinale.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.icerebro.hackFinale.JSON.JsonVoteResList;
import ru.icerebro.hackFinale.dao.interfaces.AnswerDAO;
import ru.icerebro.hackFinale.dao.interfaces.QuestionDAO;
import ru.icerebro.hackFinale.dao.interfaces.UserWatchedDAO;
import ru.icerebro.hackFinale.dao.interfaces.VoteDAO;
import ru.icerebro.hackFinale.entities.*;
import ru.icerebro.hackFinale.services.interfaces.VoteService;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteDAO voteDAO;

    private final QuestionDAO questionDAO;

    private final AnswerDAO answerDAO;

    private final UserWatchedDAO userWatchedDAO;

    @Autowired
    public VoteServiceImpl(VoteDAO voteDAO, QuestionDAO questionDAO, AnswerDAO answerDAO, UserWatchedDAO userWatchedDAO) {
        this.voteDAO = voteDAO;
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;
        this.userWatchedDAO = userWatchedDAO;
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

    @Override
    public JsonVoteResList voteNow(User loggedInUser, Integer qId, Integer answ) {
        Question question = questionDAO.getQuestions(qId);
        Answer answer = answerDAO.getAnswers(answ);
        answer.setVotecount(answer.getVotecount() + 1);
        answerDAO.updateAnswer(answer);

        Userwatched userwatched = new Userwatched();
        userwatched.setUser(loggedInUser);
        userwatched.setQuestion(question);
        userWatchedDAO.saveUserWatched(userwatched);

        List<Answer> answers = answerDAO.getAnswers(question);
        return new JsonVoteResList(qId, answers);
    }

    @Override
    public Userwatched isAnswered(User loggedUser, Question question) {
        return userWatchedDAO.getUserWatched(loggedUser, question);
    }

    @Override
    public List<Userwatched> isAnswered(User loggedUser) {
        return userWatchedDAO.getUserWatched(loggedUser);
    }
}
