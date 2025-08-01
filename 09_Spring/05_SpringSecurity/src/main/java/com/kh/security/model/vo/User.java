package com.kh.security.model.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class User implements UserDetails { // UserDetails 를 불러와 매칭시킴
	private String id;
	private String pwd;
	private String name;
	private String role;
	
	@Override // 권한 부여
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role));
	}
	
	@Override // 시큐리티의 비밀번호와 변수 매칭
	public String getPassword() {
		return this.pwd;
	}
	
	@Override // 시큐리티의 이름과 변수 매칭
	public String getUsername() {
		return this.id;
	}
}
