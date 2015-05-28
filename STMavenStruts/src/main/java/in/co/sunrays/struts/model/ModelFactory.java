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
	 * Get instance of Marksheet Model
	 * 
	 * @return model
	 */
	public MarksheetModelInt getMarksheetModel() {
		MarksheetModelInt marksheetService = (MarksheetModelInt) serviceCache
				.get("marksheetModel");
		if (marksheetService == null) {
			if ("Hibernate".equals(DATABASE)) {
				marksheetService = new MarksheetModelHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				marksheetService = new MarksheetModelJDBCImpl();
			}
			serviceCache.put("marksheetModel", marksheetService);
		}

		return marksheetService;
	}

	/**
	 * Get instance of Collage Service
	 * 
	 * @return collage
	 */
	public CollegeModelInt getCollegeModel() {
		CollegeModelInt collegeService = (CollegeModelInt) serviceCache
				.get("collegeModel");
		if (collegeService == null) {
			if ("Hibernate".equals(DATABASE)) {
				collegeService = new CollegeModelHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				collegeService = new CollegeModelJDBCImpl();
			}
			serviceCache.put("collegeModel", collegeService);
		}

		return collegeService;
	}

	/**
	 * Get instance of Student Service
	 * 
	 * @return Student
	 */
	public StudentModelInt getStudentModel() {
		StudentModelInt studentService = (StudentModelInt) serviceCache
				.get("studentModel");
		if (studentService == null) {
			if ("Hibernate".equals(DATABASE)) {
				studentService = new StudentModelHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				studentService = new StudentModelJDBCImpl();
			}
			serviceCache.put("studentModel", studentService);
		}

		return studentService;
	}

	/**
	 * Get instance of Role Model
	 * 
	 * @return Role
	 */
	public RoleModelInt getRoleModel() {
		RoleModelInt roleService = (RoleModelInt) serviceCache.get("roleModel");
		if (roleService == null) {
			if ("Hibernate".equals(DATABASE)) {
				roleService = new RoleModelHibImpl();
			}
			if ("JDBC".equals(DATABASE)) {
				roleService = new RoleModelJDBCImpl();
			}
			serviceCache.put("roleModel", roleService);
		}

		return roleService;

	}
}
