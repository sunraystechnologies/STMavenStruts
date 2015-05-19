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

	public String execute() {

		if ("admin".equals(userId) && "admin".equals(password)) {
			return SUCCESS;
		} else {
			error = "Invalid ID/Password";
			return ERROR;
		}

	}

}
