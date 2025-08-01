package com.kh.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserMapper mapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	public void register(User vo) {
		System.out.println("암호화 전 : " + vo.getPwd());
		System.out.println("암호화 후 : " + bcpe.encode(vo.getPwd()));
		vo.setPwd(bcpe.encode(vo.getPwd()));
		if(vo.getId().equals("admin")) {
			vo.setRole("ROLE_ADMIN");
		} else {
			vo.setRole("ROLE_USER");
		}
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

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		User user = mapper.login(id);
		System.out.println(user);
		return user;
	}

	
}
