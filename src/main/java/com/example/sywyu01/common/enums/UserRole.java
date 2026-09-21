package com.example.sywyu01.common.enums;

public enum UserRole {
	ADMIN("관리자"),
	USER("일반유저"),
	TEMP("임시권한");
	
	private final String description;
	
	UserRole(String description){
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public String getAuthority() {
		return "ROLE_" + this.name();
	}

}
