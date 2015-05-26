package in.co.sunrays.struts.controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Front controller checks each action call in \app package, if user is not
 * logged in yet then forward it to Login page.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class FrontCtl extends AbstractInterceptor {
	/**
	 * Destroy FrontController
	 */
	public void destroy() {
		System.out.println("FrontCtl Destroy");
	}

	/**
	 * Initialize FrontController
	 */
	public void init() {
		System.out.println("FrontCtl Init");
	}

	/**
	 * Performs FrontController Task
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		ActionSupport actionSupport = (ActionSupport) actionInvocation
				.getAction();
		Map session = actionInvocation.getInvocationContext().getSession();

		if (session.get("user") == null) {
			return "sessionExpired";
		}
		return actionInvocation.invoke();
	}

}