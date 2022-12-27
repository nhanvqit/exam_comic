package com.nhan.comic.dao;

import com.nhan.comic.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImplement implements UserDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImplement(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        return theQuery.getResultList();
    }

    @Override
    public void saveUserData(User userData) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(userData);
    }

    @Override
    public User getUserById(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, userId);
    }

    @Override
    public void removeUserById(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(currentSession.get(User.class, userId));
    }

    @Override
    public boolean checkEmailIsExist(String email, int userId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> theQuery = currentSession.createQuery("from User where email = :email and id != :userId", User.class);
        theQuery.setParameter("email", email);
        theQuery.setParameter("userId", userId);

        return !theQuery.getResultList().isEmpty();
    }

    @Override
    public User findUserByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> theQuery = currentSession.createQuery("from User where email = :email");
        theQuery.setParameter("email", email);

        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }
}
