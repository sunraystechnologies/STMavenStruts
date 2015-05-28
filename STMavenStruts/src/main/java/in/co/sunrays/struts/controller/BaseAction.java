package in.co.sunrays.struts.controller;

import in.co.sunrays.struts.dto.BaseDTO;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * Base Action class of project. It contain (1) Generic operations (2) Generic
 * constants (3) Generic work flow.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public abstract class BaseAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, ApplicationAware,
		SessionAware, Preparable {

	/**
	 * Operation constants
	 */
	protected static final String OP_SAVE = "Save";
	protected static final String OP_NEW = "New";
	protected static final String OP_DELETE = "Delete";
	protected static final String OP_CANCEL = "Cancel";
	protected static final String OP_ERROR = "Error";
	protected static final String OP_NEXT = "Next";
	protected static final String OP_PREVIOUS = "Previous";
	protected static final String OP_SIGNIN = "Sign In";
	protected static final String OP_SIGNUP = "Sign Up";
	protected static final String OP_LOGOUT = "Logout";
	protected static final String OP_GO = "Go";

	/**
	 * Non business primary key
	 */
	protected long id;

	/**
	 * UI Operation value
	 */
	protected String operation;
	/**
	 * Container objects
	 */
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map session;
	protected Map application;

	/**
	 * Implemented methods of Aware Intefaces
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * accessor
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * Performs display operations
	 */
	@Override
	public abstract String input() throws Exception;

	/**
	 * Performs submit operations
	 */
	@Override
	public abstract String execute() throws Exception;

	/**
	 * Restrict manual validation
	 */
	@Override
	public final void validate() {
		super.validate();
	}

	/**
	 * Loads pre-loaded data
	 */
	public void prepare() throws Exception {

	}

	/**
	 * Populates generic attributes into DTO from Action attributes
	 */
	protected <T extends BaseDTO> T populateDTO(T dto) {
		return dto;
	}

}