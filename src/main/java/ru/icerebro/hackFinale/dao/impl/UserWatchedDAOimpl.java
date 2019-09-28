package ru.icerebro.hackFinale.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icerebro.hackFinale.dao.interfaces.UserWatchedDAO;
import ru.icerebro.hackFinale.entities.Question;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.Userwatched;
import ru.icerebro.hackFinale.entities.Vote;

import java.util.List;

@Component
public class UserWatchedDAOimpl implements UserWatchedDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public UserWatchedDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Userwatched> getUserWatched(User user) {
        List<Userwatched> list = sessionFactory.getCurrentSession()
                .createQuery("from Userwatched where user=:user")
                .setParameter("user", user).list();
        return list;
    }

    @Override
    @Transactional
    public int saveUserWatched(Userwatched userwatched) {
        return (Integer) sessionFactory.getCurrentSession().save(userwatched);
    }

    @Override
    @Transactional
    public void deleteUserWatched(Userwatched userwatched) {
        sessionFactory.getCurrentSession().delete(userwatched);
    }

    @Override
    @Transactional
    public void updateUserWatched(Userwatched userwatched) {
        sessionFactory.getCurrentSession().update(userwatched);
    }

    @Override
    @Transactional
    public Userwatched getUserWatched(User user, Question question) {
        List<Userwatched> list = sessionFactory.getCurrentSession()
                .createQuery("from Userwatched  where user=:user and question=:q")
                .setParameter("user", user)
                .setParameter("q", question).list();

        if (list == null || list.isEmpty())
            return null;
        else
            return list.get(0);
    }
}
