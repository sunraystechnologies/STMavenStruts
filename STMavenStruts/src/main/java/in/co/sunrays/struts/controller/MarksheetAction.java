package in.co.sunrays.struts.controller;

import in.co.sunrays.struts.dto.MarksheetDTO;
import in.co.sunrays.struts.exception.ApplicationException;
import in.co.sunrays.struts.exception.DuplicateRecordException;
import in.co.sunrays.struts.model.MarksheetModelInt;
import in.co.sunrays.struts.model.ModelFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Marksheet controller. Its applies declarative server side input validation.
 * It communicate with database using hibernate Model and add/update/delete a
 * marksheet.
 * 
 * DMI need to be enabled to make it workable.
 * 
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class MarksheetAction extends ActionSupport {

	protected long id;

	/**
	 * RollNo of Student
	 */
	private String rollNo;

	/**
	 * ID of Student
	 */

	private Long studentId;
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

	private String operation = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * Contains display logic. Gets a Marksheet for update if primary key id is
	 * given.
	 */

	public String input() {
		MarksheetModelInt model = ModelFactory.getInstance()
				.getMarksheetModel();

		if (id > 0) {
			try {
				MarksheetDTO dto = model.findByPK(id);
				id = dto.getId();
				rollNo = dto.getRollNo();
				name = dto.getName();
				studentId = dto.getStudentId();
				physics = dto.getPhysics();
				maths = dto.getMaths();
				chemistry = dto.getChemistry();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		return INPUT;
	}

	/**
	 * Contains submit logic. It adds or updates a Marksheet.
	 */
	public String execute() {

		MarksheetDTO dto = new MarksheetDTO();
		dto.setId(id);
		dto.setRollNo(rollNo);
		dto.setName(name);
		dto.setStudentId(studentId);
		dto.setMaths(maths);
		dto.setPhysics(physics);
		dto.setChemistry(chemistry);

		MarksheetModelInt model = ModelFactory.getInstance()
				.getMarksheetModel();
		if ("Save".equals(operation)) {
			try {
				if (id > 0) {
					model.update(dto);
					addActionMessage("Marksheet successfully updated");
				} else {
					model.add(dto);
					addActionMessage("Marksheet successfully added");
				}

			} catch (DuplicateRecordException e) {
				addActionError(e.getMessage());
				return INPUT;
			} catch (ApplicationException e) {
				addActionError("System Error " + e.getMessage());
				return INPUT;
			}
		}
		return SUCCESS;
	}
}
