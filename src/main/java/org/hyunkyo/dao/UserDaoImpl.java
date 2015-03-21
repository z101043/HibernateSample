package org.hyunkyo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(String user_id) {

	}

	@Override
	public User getByUserId(String user_id) {
		return null;
	}

	@Override
	public int getUserCnt() {
		return 0;
	}

	@Override
	public List<User> getUserList() {
		return null;
	}

}
