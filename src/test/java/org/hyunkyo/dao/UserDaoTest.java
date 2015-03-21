package org.hyunkyo.dao;

import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.hyunkyo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml","classpath:context/**/applicationContext*.xml"})
public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

	@Autowired
	private UserDao userDao;
	
	@Test
	public void insetTest() {
		
		User user = new User("test", "테스트", "test@naver.com", new Date());
		userDao.insertUser(user);
		
	}
	
	@Test
	public void updateTest(){
		
		User user = new User("test", "업데이트1", "update@naver.com", new Date());
		userDao.updateUser(user);
		
		User result = userDao.getByUserId("test");
		
		logger.debug("결과: {}", result);
		
	}
	
	@Test
	public void deleteTest(){
		
		userDao.deleteUser("test");
		
		User result = userDao.getByUserId("test");
		
		assertNull(result);
		
	}
	
	@Test
	public void getUserTest(){
		
		User user = userDao.getByUserId("z101043");
		logger.debug("결과: {}", user);
		
	}
	
	@Test
	public void getUserCount(){
		
		Long result = userDao.getUserCnt();
		logger.debug("결과 cnt: {}", result);
	}
	
	@Test
	public void getUserList(){
		
		List<User> userList = userDao.getUserList();
		
		for (User user : userList) {
			logger.debug("결과 list : {}", user);
		}
		
	}

}