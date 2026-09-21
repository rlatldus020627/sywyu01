package com.example.sywyu01.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource(value = "classpath:error-message.properties")
public class ErrorMessagePropertySource {
	@Value("${error.message.alreadyExistedUser}")
	private String alreadyExistedUser;

	@Value("${error.message.BadCredentials}")
	private String BadBadCredentials;
	
	@Value("${error.message.UserNotFound}")
	private String UserNotFound;
	
	@Value("${error.message.NoPermission}")
	private String NoPermission;
	
	@Value("${error.message.CallDeveloper}")
	private String CallDeveloper;
}
