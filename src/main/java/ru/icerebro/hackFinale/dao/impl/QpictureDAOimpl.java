package ru.icerebro.hackFinale.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.icerebro.hackFinale.dao.interfaces.QpictureDAO;
import ru.icerebro.hackFinale.entities.Qpicture;
import ru.icerebro.hackFinale.entities.Question;

import java.util.List;

@Component
public class QpictureDAOimpl implements QpictureDAO {
    @Autowired
    private final SessionFactory sessionFactory;

    public QpictureDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Qpicture> getQpictures(Question question) {
        List<Qpicture> list = sessionFactory.getCurrentSession()
                .createQuery("from Question where Question =:q")
                .setParameter("q", question).list();
        return list;
    }

    @Override
    @Transactional
    public int saveQpicture(Qpicture qpicture) {
        return (Integer) sessionFactory.getCurrentSession().save(qpicture);
    }

    @Override
    @Transactional
    public void deleteQpicture(Qpicture qpicture) {
        sessionFactory.getCurrentSession().delete(qpicture);
    }

    @Override
    @Transactional
    public void updateQpicture(Qpicture qpicture) {
        sessionFactory.getCurrentSession().update(qpicture);
    }
}
