package com.example.sywyu01.config.jwt;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.example.sywyu01.config.property.ErrorMessagePropertySource;
import com.example.sywyu01.config.property.JwtPropertySource;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider{
	private final JwtPropertySource jwtPropertySource;
	private final ErrorMessagePropertySource errorMessagePropertySource;
	private static final String AUTH_CLAIM_KEY ="authorities"; 
	private Key key;

	@PostConstruct
	public void init() {
		byte[] bytes = Decoders.BASE64.decode(jwtPropertySource.getSecret());
		key = Keys.hmacShaKeyFor(bytes);
	}
	
	public String createToken(Authentication authentication) {
		String authorities = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		
		Date now = new Date();
		Date expiration = new Date(now.getTime()+jwtPropertySource.getExpirationMilliseconds());
		
		return Jwts.builder().setIssuedAt(now)
				.setIssuer(jwtPropertySource.getIss())
				.setSubject(authentication.getName())
				.setExpiration(expiration)
				.claim(AUTH_CLAIM_KEY, authorities)
				.signWith(key)
				.compact();
	}
	
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		//Jwts.parserBuilder() - 파서 생성
		//.setSigningKey(key) - 검증에 쓸 키 지정/key: jwtPropertySource.getSecret()
		//.build(). - 여기까지 파서 완성
		//parseClaimsJws(token) - 문제 있는지 검증, 문제 있을 시 예외 발생, 만약 없을 시 -> 
		//.getBody(); - 객체 변환
		
		Collection<? extends GrantedAuthority> authorities = 
												Arrays.stream(claims.get(AUTH_CLAIM_KEY).toString().split(","))
												.map(SimpleGrantedAuthority::new)
												.toList();
		
		User principal = new User(claims.getSubject(), "", authorities);
		//principal - User 클래스(=구현체)
		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	} 
	public boolean isValidToken(String token) throws Exception/*토큰이 유효한지 검증하는 메서드*/{
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
			//토큰이 유효하면 true return
			
		} catch(SecurityException | MalformedJwtException e) /* | = or */
		/*SecurityException - 토큰을 제대로 받았지만 인증 실패(ex-위조된 토큰 등)
		 * MalformedJwtException - 토큰이 깨지는 등 손상되어 애당초 받지 못함*/{
			throw new Exception(errorMessagePropertySource.getCallDeveloper());
		}
		//TODO:에러코드 수정1
	}
}



