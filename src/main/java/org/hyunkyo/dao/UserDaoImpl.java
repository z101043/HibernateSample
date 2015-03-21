package org.hyunkyo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hyunkyo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
	}

	@Override
	public void deleteUser(String user_id) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUser_id(user_id);
		
		session.delete(user);
		
		session.getTransaction().commit();

	}

	@Override
	public User getByUserId(String user_id) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		User user = (User) session.get(User.class, user_id);
		
		session.getTransaction().commit();
		
		return user;
	}

	@Override
	public Long getUserCnt() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Long result = (Long) session.createCriteria(User.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
		session.getTransaction().commit();
		
		return result;
	}

	@Override
	public List<User> getUserList() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>)session.createCriteria(User.class).list();
		session.getTransaction().commit();
		return userList;
	}

}
