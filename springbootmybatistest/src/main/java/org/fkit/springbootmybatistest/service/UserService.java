package org.fkit.springbootmybatistest.service;

import java.util.List;

import javax.annotation.Resource;

import org.fkit.springbootmybatistest.bean.User;
import org.fkit.springbootmybatistest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Resource
	private UserRepository userRepository;
	public int insertUser(User user) {
		return userRepository.insertUser(user);
	}
	public User selectByUsername(String username) {
		return userRepository.selectByUsername(username);
	} 
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public void insertGetKey(User user){
		userRepository.insertGetKey(user);
	}
	public String update(User user){
		userRepository.update(user);
		return "update sucess";
	}
	public void delete(Integer id){
		userRepository.delete(id);
	}
	
}


