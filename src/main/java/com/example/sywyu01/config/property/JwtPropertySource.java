package com.example.sywyu01.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource(value = "classpath:application.properties")
@Getter
public class JwtPropertySource {
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.iss}") //iss는 issuer의 약자로, 토큰 발급자를 나타냄
	private String iss;
	
	@Value("${jwt.expiration-milliseconds}")
	private long expirationMilliseconds;
	
	@Value("${cookie.jwt.name}")
	private String cookieName; //토큰을 쿠키에 담을 때 사용할 쿠키 이름
	
	@Value("${cookie.jwt.http-only}")
	private boolean isEnableHttpOnly; //쿠키의 HttpOnly 옵션 여부
	
	@Value("${cookie.jwt.secure}")
	private boolean isEnableSecure;//쿠키의 Secure 여부
	
	@Value("${cookie.jwt.path}")
	private String path;
	
	@Value("${cookie.jwt.maxAge}")
	private long maxAge; //쿠키 만료 시간

}
