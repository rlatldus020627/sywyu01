package com.example.molpagemb.common.utils;

import java.security.Principal;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

public class AuthUtil {
	private AuthUtil() {}
	public static Long getUserId(Principal principal) {
		if(principal == null) {
			throw new AuthenticationCredentialsNotFoundException("인증정보가 없습니다.");
		}
		return Long.parseLong(principal.getName());
	}

}
