package com.example.sywyu01.user.service;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import com.example.sywyu01.common.enums.UserRole;
import com.example.sywyu01.user.dto.CreateUserDTO;
import com.example.sywyu01.user.dto.SignInUserDTO;
import com.example.sywyu01.user.dto.UserDTO;

public interface UserService {
	List<UserDTO> findAllUsers();
	List<UserDTO> findAllUsersByUserRole(@Param("userRole") UserRole userRole);
	UserDTO findUserByUserId(String userId);
	UserDTO findUserByUserIdNumber(Long userIdNumber);
	List<UserRole> findRolesByUserIdNumber(Long userIdNumber);
	String createToken(SignInUserDTO signInUserDTO);
	
	void createUser(CreateUserDTO createUserDTO);
	void addUserRole(@Param("userIdNumber") Long userIdNumber, @Param("role") UserRole role);
	
	Optional<UserDTO> getLoggedUserId(); //로그인한 사용자 조회
	
	boolean existsByUserId(String userId);

}
