package com.example.demoretrofitspringboot.user;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rolename;

	public Role(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String getAuthority() {
		return rolename;
	}

}
