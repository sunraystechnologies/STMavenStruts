package in.co.sunrays.struts.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Login Action example
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class LoginAction extends ActionSupport {

	private String userId = null;
	private String password = null;
	private String error = null;

	/**
	 * Programmatic (manual) Input validation
	 */
	@Override
	public void validate() {
		if (userId == null || userId.length() == 0) {
			addFieldError("userId", "User ID can not be null");
		}

		if (password == null || password.length() == 0) {
			addFieldError("password", "Password can not be null");
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Contains display logic. Input validation is NOT performed.
	 */
	public String input() {
		return INPUT;

	}

	/**
	 * Contains submit logic. Input validation is performed.
	 */
	public String execute() {

		if ("admin".equals(userId) && "admin".equals(password)) {
			return SUCCESS;
		} else {
			// Add error to action that is displayed at view using
			// <s:actionError/> tag
			addActionError("Invalid ID/Password");
			return INPUT;
		}

	}

}
