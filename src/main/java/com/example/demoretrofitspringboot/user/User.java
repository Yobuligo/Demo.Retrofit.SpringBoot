package com.example.demoretrofitspringboot.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User implements UserDetails {
	private String username;
	private String password;
	private List<Role> roles;

	public User(String username, String password, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.addAll(roles);
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
		return bCryptPasswordEncoder.encode(password);
		// return "{myPrefix}" + bCryptPasswordEncoder.encode(password);
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
