package in.co.sunrays.struts.model;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Factory of Service classes
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 * 
 */

/**
 * @author 123
 * 
 */
public class ModelFactory {

	private static ResourceBundle bundle = ResourceBundle
			.getBundle("in.co.sunrays.struts.bundle.system");

	private static final String DATABASE = bundle.getString("DATABASE");
	private static ModelFactory serviceLocator = null;
	/**
	 * Cache of Service classes
	 */
	private static HashMap serviceCache = new HashMap();

	/**
	 * Constructor is private so no other class can create instance of Service
	 * Locator
	 */
	private ModelFactory() {

	}

	/**
	 * Get the instance of Service Locator
	 * 
	 * @return serviceLocator
	 */
	public static ModelFactory getInstance() {
		if (serviceLocator == null) {
			serviceLocator = new ModelFactory();
		}
		return serviceLocator;
	}

	/**
	 * Get instance of Marksheet Service
	 * 
	 * @return marksheetService
	 */
	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetService = (MarksheetModelInt) serviceCache
				.get("marksheetService");
		if (marksheetService == null) {
			if ("Hibernate".equals(DATABASE)) {
				marksheetService = new MarksheetModelHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetService = new MarksheetModelJDBCImpl();
			}
			serviceCache.put("marksheetService", marksheetService);
		}

		return marksheetService;
	}

}
