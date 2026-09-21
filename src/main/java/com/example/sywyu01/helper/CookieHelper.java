package com.example.sywyu01.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import com.example.sywyu01.config.property.JwtPropertySource;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CookieHelper { //쿠키 생성
	private final JwtPropertySource jwtPropertySource;
	
	public String makeJwtCookie(String jwt) {
		return ResponseCookie
							.from(jwtPropertySource.getCookieName(), jwt)
							.httpOnly(jwtPropertySource.isEnableHttpOnly())
							.secure(jwtPropertySource.isEnableSecure())
							.path(jwtPropertySource.getPath())
							.maxAge(jwtPropertySource.getMaxAge())
							.build().toString();
	}
	
	public void deleteJwtCookie(HttpHeaders httpHeaders) { //쿠키 삭제
		String cookie = ResponseCookie
									.from(jwtPropertySource.getCookieName())
									.path(jwtPropertySource.getPath())
									.maxAge(0)
									.build()
									.toString();
		httpHeaders.add("set-cookie", cookie);
	}
}
