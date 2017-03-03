package com.springapp.mvc.dao;

import com.springapp.mvc.model.Resources;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Maxim.Temborskiy on 21.01.2017.
 */
@Repository
public class ResourcesDaoImpl implements ResourcesDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addResources(Resources resources) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(resources);
    }

    @Override
    public void removeResources(Date time) {

    }

    @Override
    public Resources getResourcesByTime(Date time) {
        return null;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Resources> listResources() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Resources> resourcesList = session.createQuery("FROM Resources order by time desc").list();

        return resourcesList;
    }

    @Override
    public List<Resources> listLimitedResources() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Resources> resourcesList = session.createQuery("FROM Resources order by time desc").setFirstResult(0).setMaxResults(30).list(); //last 30 rows

        return resourcesList;
    }
}
