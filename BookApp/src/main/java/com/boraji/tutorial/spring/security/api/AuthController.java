package com.boraji.tutorial.spring.security.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.security.dto.LoginRequest;
import com.boraji.tutorial.spring.security.dto.LoginResponse;
import com.boraji.tutorial.spring.security.jwt.JwtProvider;
import com.boraji.tutorial.spring.security.service.UserPrincipal;

@RestController
@RequestMapping(value="/api")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider jwtProvider;
	
	
	@PostMapping(value="/login")
	
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication=authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt=jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(createResponse(authentication,jwt));
		
	}


	private LoginResponse createResponse(Authentication authentication, String token) {
		UserPrincipal userPrincipal =(UserPrincipal)authentication.getPrincipal();
		LoginResponse  loginResponse=new LoginResponse();
		loginResponse.setId(userPrincipal.getId());
		loginResponse.setUsername(userPrincipal.getUsername());
		loginResponse.setToken(token);
		loginResponse.setEmail(userPrincipal.getEmail());
		loginResponse.setName(userPrincipal.getName());
		loginResponse.setSurname(userPrincipal.getSurname());
		List <String> rolesAsStringList =userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
		loginResponse.setRoles(rolesAsStringList);
		return loginResponse;
	}

}
