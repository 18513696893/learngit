package org.fkit.springbootjdbctemplate.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.fkit.springbootjdbctemplate.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	@Resource
	private JdbcTemplate jdbctemplate;
	public int insertUser(){
		String sql ="insert into tb_user (login_name,username,passWord)"
				+"value(?,?,?),(?,?,?),(?,?,?)";
		Object[] args=new Object[] {"swk","孙悟空","123456","zbj","猪八戒","123456","ts","唐僧","123456"};
		return jdbctemplate.update(sql,args);
	}	
	public User selectByUsername(String username) {
		String sql="select * from tb_user where username =?";
		RowMapper<User>rowMapper=new BeanPropertyRowMapper<>(User.class);
		User user=jdbctemplate.queryForObject(sql, new Object[] {username},rowMapper);
		return user;
	}	
	public User findUserByid(int id) {
		String sql ="select * from tb_user where id =?";
		RowMapper<User>rowMapper=new BeanPropertyRowMapper<>(User.class);
		return jdbctemplate.queryForObject(sql, new Object[] {id},rowMapper);
	}
	public List<User>findAll(){
		String sql="select * from tb_user ";
		RowMapper<User>rowMapper=new BeanPropertyRowMapper<>(User.class);
		return jdbctemplate.query(sql,rowMapper);
	}
	public void delete(final Integer id) {
		String sql ="delete * from tb_user where id =?";
		jdbctemplate.update(sql, new Object[] {id});	
	}
	public void update(final User user) {
		String sql ="update tb_user set username=?,login_name=? where id =?";
		jdbctemplate.update(sql, new Object[] {user.getUsername(),user.getLoginName(),user.getId()});
	}
	public User insertGetKey(User user) {
		String sql ="insert into tb_user (login_name,username,passWord) value (?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbctemplate.update(new PreparedStatementCreator() {	
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getLoginName());
				ps.setString(3, user.getPassword());
				return ps;
			}
		},holder);
		int newUserid=holder.getKey().intValue();
		user.setId(newUserid);
		return user;
		
	}
	
	
}
