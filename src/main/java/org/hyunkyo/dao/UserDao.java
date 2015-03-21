package org.hyunkyo.dao;

import java.util.List;

import org.hyunkyo.domain.User;

public interface UserDao {

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(String user_id);

	public User getByUserId(String user_id);

	public int getUserCnt();

	public List<User> getUserList();

}
