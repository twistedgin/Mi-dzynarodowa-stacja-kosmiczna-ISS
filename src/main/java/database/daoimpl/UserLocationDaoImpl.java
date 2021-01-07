package database.daoimpl;

import database.dao.UserLocationDao;
import database.entity.UserLocation;
import database.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class UserLocationDaoImpl implements UserLocationDao {

    @Override
    public void save(UserLocation userLocation) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(userLocation);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public UserLocation findById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        UserLocation userLocation = null;

        try {
            userLocation = session
                    .createQuery("from UserLocation where id=:id", UserLocation.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return userLocation;
    }

    @Override
    public List<UserLocation> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<UserLocation> userLocation = new ArrayList<>();

        try {

            userLocation = session
                    .createQuery("from UserLocation", UserLocation.class)
                    .list();

        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return userLocation;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session
                .createQuery("delete UserLocation where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}


