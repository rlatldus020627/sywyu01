package com.example.sywyu01.user.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.sywyu01.common.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDTO {
	private Long userIdNumber;
	private String userId;
	private List<UserRole> userRole;
	
	@JsonIgnore
	private String userPassword;
	
	private LocalDateTime userCreatedAt;
	
	
}
