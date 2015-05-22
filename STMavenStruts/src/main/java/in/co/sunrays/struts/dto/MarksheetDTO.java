package in.co.sunrays.struts.dto;

/**
 * Marksheet JavaBean encapsulates Marksheet attributes
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class MarksheetDTO extends BaseDTO {

	/**
	 * Rollno of Student
	 */
	private String rollNo;
	
	/**
	 * ID of Student
	 */
	
	private long studentId;
	/**
	 * Name of Student
	 */
	private String name;
	/**
	 * Physics marks of Student
	 */
	private Integer physics;
	/**
	 * Chemistry marks of Student
	 */
	private Integer chemistry;
	/**
	 * Mathematics marks of Student
	 */
	private Integer maths;

	/**
	 * accessor
	 */
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

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return rollNo;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
