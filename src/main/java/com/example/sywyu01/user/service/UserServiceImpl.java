package com.example.sywyu01.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sywyu01.common.enums.UserRole;
import com.example.sywyu01.config.exception.AlreadyExistedUserException;
import com.example.sywyu01.config.exception.UserNotFoundException;
import com.example.sywyu01.config.jwt.JwtTokenProvider;
import com.example.sywyu01.config.property.ErrorMessagePropertySource;
import com.example.sywyu01.helper.SecurityHelper;
import com.example.sywyu01.user.dto.CreateUserDTO;
import com.example.sywyu01.user.dto.SignInUserDTO;
import com.example.sywyu01.user.dto.UserDTO;
import com.example.sywyu01.user.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final JwtTokenProvider jwtTokenProvider;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	private final ErrorMessagePropertySource errorMessagePropertySource;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	@Override
	public List<UserDTO> findAllUsers() {
		return userMapper.findAllUsers();
	}

	@Override
	public List<UserDTO> findAllUsersByUserRole(UserRole userRole) {
		return userMapper.findAllUsersByUserRole(userRole);
	}

	@Override
	public UserDTO findUserByUserId(String userId) {
		return userMapper.findUserByUserId(userId);
	}
	
	@Override
	public UserDTO findUserByUserIdNumber(Long userIdNumber) {
		return userMapper.findUserByUserIdNumber(userIdNumber);
	}

	@Override
	public String createToken(SignInUserDTO signInUserDTO) {
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken(signInUserDTO.getUserId(), signInUserDTO.getUserPassword());
			
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
			return jwtTokenProvider.createToken(authentication);
					
		}catch(AuthenticationException ex) {
			throw new BadCredentialsException(errorMessagePropertySource.getBadBadCredentials());
			
		}
		
	}
	
	@Override
	public void createUser(CreateUserDTO createUserDTO) {
		UserDTO user = userMapper.findUserByUserId(createUserDTO.getUserId());
		if(user != null) {
			throw new AlreadyExistedUserException(errorMessagePropertySource.getAlreadyExistedUser());
		}
		createUserDTO.setUserPassword(passwordEncoder.encode(createUserDTO.getUserPassword()));
		userMapper.createUser(createUserDTO);
		
	}

	@Override
	public Optional<UserDTO> getLoggedUserId() {
		Optional<String> loggedUserId = SecurityHelper.getLoggedUserId();
		
		return loggedUserId.map(userMapper::findUserByUserId);
	}

	@Override
	public boolean existsByUserId(String userId) {
		return userMapper.existsByUserId(userId) > 0;
	}

	@Override
	public List<UserRole> findRolesByUserIdNumber(Long userIdNumber) {
		return userMapper.findRolesByUserIdNumber(userIdNumber);
	}

	@Override
	public void addUserRole(Long userIdNumber, UserRole role) {
		//실제 존재하는 유저인지 확인
		UserDTO user = userMapper.findUserByUserIdNumber(userIdNumber);
		//존재하지 않는 유저라면 에러
		if(user == null) {
			throw new UserNotFoundException(errorMessagePropertySource.getUserNotFound());
		}
		//실제 존재하는 유저라면 권한 부여
		userMapper.addUserRole(userIdNumber, role);
		
	}
	
	//TODO 로그아웃
	
	




}
