package org.learnhow.ws.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.learnhow.ws.schema.Gender;
import org.learnhow.ws.schema.User;
import org.springframework.stereotype.Component;

@Component
public class UserRespository {
	
	private static final Map<String,User> users = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		
		User user = new User();
		user.setName("zhangsan");
		user.setAge(25);
		user.setAddress("杭州市下城区");
		user.setGender(Gender.MALE);
		users.put(user.getName(), user);
		
		user = new User();
		user.setName("lisi");
		user.setAge(24);
		user.setAddress("杭州市萧山区");
		user.setGender(Gender.MALE);
		users.put(user.getName(), user);
		
		user = new User();
		user.setName("liuyifei");
		user.setAge(23);
		user.setAddress("北京市");
		user.setGender(Gender.FEMALE);
		users.put(user.getName(), user);
	}
	
	public User findUser(String name) {
		return users.get(name);
	}
	
}
