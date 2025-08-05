package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.kh.security.config.TokenProvider;
import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService {

    private final TokenProvider tokenProvider;

	@Autowired
	private UserMapper mapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

    UserService(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }
	
	public void register(User vo) {
		//System.out.println("암호화 전 : " + vo.getPwd());
		//System.out.println("암호화 후 : " + bcpe.encode(vo.getPwd()));
		
		vo.setPwd(bcpe.encode(vo.getPwd()));
		if(vo.getId().equals("admin")) {
			vo.setRole("ROLE_ADMIN");
		} else {
			vo.setRole("ROLE_USER");
		}
		mapper.register(vo);
	}

	public User login(User vo) {
		User user = mapper.login(vo.getId());
		
		if(user!=null && bcpe.matches(vo.getPwd(), user.getPwd())) {
			System.out.println("로그인 성공!");
			//System.out.println(vo);
			return user;
		}
		return null;
	}


	
}
