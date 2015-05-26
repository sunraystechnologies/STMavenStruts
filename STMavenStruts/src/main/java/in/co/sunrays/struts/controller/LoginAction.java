package in.co.sunrays.struts.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Login Action controller. It applies server side manual validation. DMI should
 * be enabled to run this example. Aware interface SessionAware is used to
 * inject Web Session object to Action.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class LoginAction extends ActionSupport implements SessionAware {

	private String userId = null;
	private String password = null;
	private String error = null;
	private String operation = null;
	private Map<String, Object> session = null;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * Contains display logic. Input validation is NOT performed.
	 */
	public String input() {
		session.clear();
		return INPUT;
	}

	/**
	 * Contains submit logic. Input validation is performed.
	 */
	public String execute() {

		if ("admin".equals(userId) && "admin".equals(password)) {
			session.put("user", "admin");
			return SUCCESS;

		} else {
			// Add error to action that is displayed at view using
			// <s:actionError/> tag
			addActionError("Invalid ID/Password");
			return INPUT;
		}

	}

}
