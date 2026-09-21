package com.example.sywyu01.helper;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityHelper {
	public static Optional<String> getLoggedUserId(){
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null) {
			return Optional.empty();
		}
		
		String loggedUserId = null;
		if(authentication.getPrincipal() instanceof UserDetails springSecurityUser) { 
			loggedUserId = springSecurityUser.getUsername();
		} else if(authentication.getPrincipal() instanceof String) {
			loggedUserId = (String) authentication.getPrincipal(); //익셩사용자의 경우
		}
		return Optional.ofNullable(loggedUserId);
	}

}
