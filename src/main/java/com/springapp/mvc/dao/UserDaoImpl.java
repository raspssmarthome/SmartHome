package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Maxim.Temborskiy on 19.11.2016.
 */

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if (user!=null){
            session.delete(user);
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List <User> userList = session.createQuery("FROM User").list();
        return userList;
    }


}
