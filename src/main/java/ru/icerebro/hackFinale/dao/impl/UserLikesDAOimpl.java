package ru.icerebro.hackFinale.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icerebro.hackFinale.dao.interfaces.UserLikesDAO;
import ru.icerebro.hackFinale.entities.User;
import ru.icerebro.hackFinale.entities.UserLikes;

import java.util.List;

@Component
public class UserLikesDAOimpl implements UserLikesDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public UserLikesDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<UserLikes> getUserLikes(User user) {
        List<UserLikes> list = sessionFactory.getCurrentSession()
                .createQuery("from UserLikes where user=:user")
                .setParameter("user", user).list();
        return list;
    }

    @Override
    @Transactional
    public int saveUserLikes(UserLikes UserLikes) {
        return (Integer) sessionFactory.getCurrentSession().save(UserLikes);
    }

    @Override
    @Transactional
    public void deleteUserLikes(UserLikes userLikes) {
        sessionFactory.getCurrentSession().delete(userLikes);
    }

    @Override
    @Transactional
    public void updateUserLikes(UserLikes userLikes) {
        sessionFactory.getCurrentSession().delete(userLikes);
    }

    @Override
    @Transactional
    public UserLikes getUserLikes(User loggedInUser, Integer heart) {
        List<UserLikes> list = sessionFactory.getCurrentSession()
                .createQuery("from UserLikes where user=:user and votecategory=:heart")
                .setParameter("user", loggedInUser)
                .setParameter("heart", heart)
                .list();

        if (list == null || list.isEmpty()){
            return null;
        }else {
            return list.get(0);
        }
    }
}
