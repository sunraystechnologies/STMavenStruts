package in.co.sunrays.struts.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Person Action, simple input validation example.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class PersonAction extends ActionSupport {

	private String name;

	private Integer age;

	private Integer answer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

	public String execute() {

		return SUCCESS;

	}

}
