package ru.icerebro.hackFinale.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icerebro.hackFinale.dao.interfaces.QuestionDAO;
import ru.icerebro.hackFinale.entities.Question;
import ru.icerebro.hackFinale.entities.UserLikes;
import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

@Component
public class QuestionDAOimpl implements QuestionDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public QuestionDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Question> getQuestions(Vote vote) {
        List<Question> list = sessionFactory.getCurrentSession()
                .createQuery("from Question where Vote =:vote")
                .setParameter("vote", vote).list();
        return list;
    }

    @Override
    @Transactional
    public int saveQuestions(Question qpicture) {
        return (Integer) sessionFactory.getCurrentSession().save(qpicture);
    }

    @Override
    @Transactional
    public void deleteQuestions(Question qpicture) {
        sessionFactory.getCurrentSession().delete(qpicture);
    }

    @Override
    @Transactional
    public void updateQuestions(Question qpicture) {
        sessionFactory.getCurrentSession().update(qpicture);
    }
}
