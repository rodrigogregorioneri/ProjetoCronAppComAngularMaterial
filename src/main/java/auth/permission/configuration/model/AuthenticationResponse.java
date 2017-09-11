package auth.permission.configuration.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import app.entity.User;

public class AuthenticationResponse {

	private User user;
	private String token;
	private Long expires;
	private String roles;
	private Boolean root;

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(User user, String token, Long expires, String roles, Boolean root) {
		this.setUser(user);
		this.setToken(token);
		this.setExpires(expires);
		this.setRoles(roles);
		this.setRoot(root);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}

	public Boolean getRoot() {
		return root;
	}

	public void setRoot(Boolean root) {
		this.root = root;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
