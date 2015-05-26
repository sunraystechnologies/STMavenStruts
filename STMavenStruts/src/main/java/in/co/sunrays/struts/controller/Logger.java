package in.co.sunrays.struts.controller;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Logs system timestamp before and after action call.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 * 
 */

public class Logger extends AbstractInterceptor {
	/**
	 * Destroy FrontController
	 */
	public void destroy() {
		System.out.println("Logger destroy");
	}

	/**
	 * Initialize FrontController
	 */
	public void init() {
		System.out.println("Logger init");
	}

	/**
	 * Performs FrontController Task
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		ActionSupport actionSupport = (ActionSupport) actionInvocation
				.getAction();
		Date d = new Date();
		System.out.println(actionSupport.getClass().getName() + " called at "
				+ d);

		return actionInvocation.invoke();
	}

}