package org.fkit.crudrepositorytest.controller;

import javax.annotation.Resource;

import org.fkit.crudrepositorytest.bean.User;
import org.fkit.crudrepositorytest.service.UserServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserServices userServices;
	
	@RequestMapping("/save")
	public String save() {
		User user =new User();
		user.setLoginName("dlei");
		user.setAge(20);
		user.setSex('男');
		user.setUsername("老磊");
		return "数据保存成功！";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		userServices.delete(1);
		return "删除数据成功";
	}
	
	@RequestMapping("/update")
	public String update() {
		User user = userServices.getbyID(1);
		userServices.update(user);
		return "修改成功!";
	}

	@RequestMapping("/getAll")
	public Iterable<User> getAll(){
		return userServices.getAll();
	}
	
}
