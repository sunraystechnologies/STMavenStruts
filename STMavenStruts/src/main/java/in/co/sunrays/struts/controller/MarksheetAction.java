package in.co.sunrays.struts.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Marksheet Action with declarative server side input validation
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class MarksheetAction extends ActionSupport {

	private String error = null;
	private String rollNo = null;
	private String name = null;
	private int maths = 0;
	private int physics = 0;
	private int chemistry = 0;
	private String operation = null;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String execute() {
		return SUCCESS;
	}

}
