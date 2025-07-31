package com.kh.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	public void register(User vo) {
		mapper.register(vo);
	}

	public User login(String id) {
		return mapper.login(id);
	}
	
	public List<User> selectAll() {
		return mapper.selectAll();
	}
	
	public List<User> select(User vo) {
		return mapper.select(vo);
	}
	
	public void update(User vo) {
		mapper.update(vo);
	}
	
	public void delete(List<String> idList) {
		mapper.delete(idList);
	}

	
}
