package ru.icerebro.hackFinale.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icerebro.hackFinale.dao.interfaces.AnswerDAO;
import ru.icerebro.hackFinale.entities.Answer;
import ru.icerebro.hackFinale.entities.Question;

import java.util.List;

@Component
public class AnswerDAOimpl implements AnswerDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public AnswerDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Answer> getAnswers(Question question) {
        List<Answer> list = sessionFactory.getCurrentSession()
                .createQuery("from Answer where question =:q")
                .setParameter("q", question).list();
        return list;
    }

    @Override
    @Transactional
    public int saveAnswer(Answer answer) {
        return (Integer) sessionFactory.getCurrentSession().save(answer);
    }

    @Override
    @Transactional
    public void deleteAnswer(Answer answer) {
        sessionFactory.getCurrentSession().delete(answer);
    }

    @Override
    @Transactional
    public void updateAnswer(Answer answer) {
        sessionFactory.getCurrentSession().update(answer);
    }

    @Override
    @Transactional
    public Answer getAnswers(Integer answ) {
        return sessionFactory.getCurrentSession().get(Answer.class, answ);
    }
}
