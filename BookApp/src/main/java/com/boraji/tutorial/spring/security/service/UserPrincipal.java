package com.boraji.tutorial.spring.security.service;

import static com.boraji.tutorial.spring.model.UserRole.ROLE_USER;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.boraji.tutorial.spring.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails{
	
	private static final long serialVersionUID = -2098935599381477527L;
	
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String surname;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority>authorities;

	public UserPrincipal(Integer id,String name ,String surname,
			String username,String email,String password,Collection<? extends GrantedAuthority> authorities) {
		
		this.id=id;
		this.name=name;
		this.username=username;
		this.email=email;
		this.password=password;
		this.authorities=authorities;
		
		
	}
	
	public static UserPrincipal build(User user) {
		
		Collection<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_USER.name()));
		
		 return new UserPrincipal(
	                user.getId(),
	                user.getName(),
	                user.getSurname(),
	                user.getUsername(),
	                user.getEmail(),
	                user.getPassword(),
	                grantedAuthorities
	        );
		
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getSurname() {
		return surname;
	}

	public Integer getId() {
		return id;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		
		return true;
	}

	public boolean isAccountNonLocked() {
		
		return true;
	}

	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	public boolean isEnabled() {
		
		return true;
	}
	public boolean equal(Object obj) {
		if(this==obj) return true;
		if(obj==null||obj.getClass()!=getClass()) return false;
			
		UserPrincipal user=(UserPrincipal)obj;
		return Objects.equals(id, user.id);
		
	}

}
