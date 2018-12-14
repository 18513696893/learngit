package org.fkit.crudrepositorytest.service;

import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.fkit.crudrepositorytest.bean.User;
import org.fkit.crudrepositorytest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	@Resource
	private UserRepository userRepository;
	
	@Transactional
	public User save(User User) {
		return userRepository.save(User);
	}
	@Transactional
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	public Iterable<User> getAll(){
		return userRepository.findAll();	
	}
	public User getbyID(Integer id){
		Optional<User>op =userRepository.findById(id);
		return op.get();
	}
	public void update(User user) {
		user.setUsername("猴个");
		user.setAge(18);
		user.setLoginName("swk");
		
	}
}
