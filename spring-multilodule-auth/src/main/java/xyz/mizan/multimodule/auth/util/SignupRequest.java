package xyz.mizan.multimodule.auth.util;

import java.util.Set;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public class SignupRequest {

	public String username;
	public String email;
	public String password;
	public Set<String> roles;
	
	public SignupRequest() {
	}
	
	
	
	public SignupRequest(String username, String email, String password, Set<String> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
}
