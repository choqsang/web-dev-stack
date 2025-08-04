package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.model.vo.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenProvider {

	private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	public String create(User user) { // 토큰 생성 클래스
		return Jwts.builder()
				.signWith(secretKey, SignatureAlgorithm.HS512)
				.setClaims(Map.of(
						"id", user.getId(),
						"name", user.getName(),
						"role", user.getRole()
				))
				.setIssuedAt(new Date()) // 토큰 발행 시점
				.setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
					// 토큰 만료 시점 (해당 세팅이 없을 경우, 계속 유지되어 보안에 문제가 생길 수 있음)
				.compact();
	}
	
	public User validate(String token) {
		Claims claims = Jwts
					.parserBuilder()
					.setSigningKey(secretKey)
					.build()
					.parseClaimsJws(token)
					.getBody();
		return User.builder()
					.id((String) claims.get("id"))
					.name((String) claims.get("name"))
					.role((String) claims.get("role"))
					.build();
	}
	
}
