package database.daoimpl;

import database.dao.UpcomingEventDao;
import database.entity.UpcomingEvent;
import database.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class UpcomingEventDaoImpl implements UpcomingEventDao {

    @Override
    public void save(UpcomingEvent upcomingEvent) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(upcomingEvent);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public UpcomingEvent findById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        UpcomingEvent upcomingEvent = null;

        try {
            upcomingEvent = session
                    .createQuery("from UpcomingEvent where id=:id", UpcomingEvent.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();
        session.close();

        return upcomingEvent;
    }

    @Override
    public List<UpcomingEvent> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<UpcomingEvent> upcomingEvent = new ArrayList<>();

        try {

            upcomingEvent = session
                    .createQuery("from UpcomingEvent", UpcomingEvent.class)
                    .list();

        } catch (NoResultException e) {
            e.printStackTrace();

        }

        session.getTransaction().commit();
        session.close();

        return upcomingEvent;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session
                .createQuery("delete UpcomingEvent where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
