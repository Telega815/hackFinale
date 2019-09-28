package ru.icerebro.hackFinale.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icerebro.hackFinale.dao.interfaces.VoteDAO;
import ru.icerebro.hackFinale.entities.UserLikes;
import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

@Component
public class VoteDAOimpl implements VoteDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public VoteDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Vote> getVotes(Integer votecategory) {
        List<Vote> list = sessionFactory.getCurrentSession()
                .createQuery("from Vote where votecategory=:votecategory")
                .setParameter("votecategory", votecategory).list();
        return list;
    }

    @Override
    @Transactional
    public int saveVote(Vote vote) {
        return (Integer) sessionFactory.getCurrentSession().save(vote);
    }

    @Override
    @Transactional
    public void deleteVote(Vote vote) {
        sessionFactory.getCurrentSession().delete(vote);
    }

    @Override
    @Transactional
    public void updateVote(Vote vote) {
        sessionFactory.getCurrentSession().update(vote);
    }
}
