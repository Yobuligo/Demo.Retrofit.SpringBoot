package com.example.demoretrofitspringboot.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserRepository implements UserDetailsService {
	private ArrayList<User> users = new ArrayList<>();

	public UserRepository() {
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("ROLE_USER"));
		users.add(new User("peter", "test", roles));

		roles = new ArrayList<>();
		roles.add(new Role("ROLE_USER"));
		users.add(new User("user", "user", roles));

		roles = new ArrayList<>();
		roles.add(new Role("ROLE_USER"));
		roles.add(new Role("ROLE_ADMIN"));
		users.add(new User("root", "admin", roles));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		for (User myUser : users) {
			String usersUsername = myUser.getUsername();
			if (usersUsername.equals(username)) {
				return myUser;
			}
		}

		throw new UsernameNotFoundException("User not found");
	}
}
