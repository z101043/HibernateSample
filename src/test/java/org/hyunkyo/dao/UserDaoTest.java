package org.hyunkyo.dao;

import java.util.Date;

import org.hyunkyo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml","classpath:context/**/applicationContext*.xml"})
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void test() {
		
		User user = new User("z101043", "김양헌", "z101043@naver.com", new Date());
		userDao.insertUser(user);
		
		//assertTrue(Boolean.TRUE);
		
	}

}