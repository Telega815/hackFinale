package ru.icerebro.hackFinale.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icerebro.hackFinale.dao.interfaces.UserDAO;
import ru.icerebro.hackFinale.entities.User;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session
                .createQuery("from User where username = :username")
                .setParameter("username", username.toLowerCase())
                .list();
        if (list.isEmpty())
            return null;

        return list.get(0);
    }

    @Transactional
    public int saveUser(User user) {
        return (Integer) sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public User getUser(Integer pageOwnerId) {
        return sessionFactory.getCurrentSession().get(User.class, pageOwnerId);
    }
}
