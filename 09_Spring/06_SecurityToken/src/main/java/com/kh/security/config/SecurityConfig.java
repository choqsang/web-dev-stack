package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 시큐리티: 기존 세션 방식이 아닌 토큰 방식으로 전환
		return http
				.csrf(csrf -> 
					csrf
						.disable()) // 웹 보안 토큰 설정 (비활성화)
				.httpBasic(basic -> 
					basic
						.disable()) // HTTP Basic 인증 방식 비활성화 -> JWT 토큰 방식 사용 (JSON Web Token)
				.sessionManagement(session -> 
					session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
						// 세션 설정 -> STATELESS 무상태 방식으로 설정
						// 애플리케이션이 세션을 전혀 생성하지 않고, 기존 세션도 사용하지 않도록 세팅
						// 인증정보는 매 요청마다 클라이언트가 제공해야 하며 서버는 세션을 유지하지 않음
				.authorizeHttpRequests(authorize -> 
					authorize
						.requestMatchers("/mypage").authenticated()
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll())
				// 기존 로그인-로그아웃 기능 상실 (개별적으로 수동 설정해주어야 한다)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				// 필터 생성 : JwtAuthenticationFilter
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		// 중복 슬래시 허용
		firewall.setAllowUrlEncodedDoubleSlash(true); // URL 인코딩된 // 허용 (%2F%2F)
		firewall.setAllowSemicolon(true); // 세미콜론도 허용할 수 있음 (선택)
		return firewall;
	}
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	}
}
