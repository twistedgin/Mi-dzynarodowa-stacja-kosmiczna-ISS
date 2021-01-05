package database.daoimpl;

import database.dao.PeopleInSpaceDao;
import database.entity.PeopleInSpace;
import database.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class PeopleInSpaceDaoImpl implements PeopleInSpaceDao {
    @Override
    public void save(PeopleInSpace peopleInSpace) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(peopleInSpace);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public PeopleInSpace findById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        PeopleInSpace peopleInSpace = null;

        try {
            peopleInSpace = session
                    .createQuery("from PeopleInSpace where id=:id", PeopleInSpace.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return peopleInSpace;
    }

    @Override
    public List<PeopleInSpace> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<PeopleInSpace> peopleInSpaces = new ArrayList<>();

        try {

            peopleInSpaces = session
                    .createQuery("from PeopleInSpace", PeopleInSpace.class)
                    .list();

        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return peopleInSpaces;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session
                .createQuery("delete PeopleInSpace where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}

