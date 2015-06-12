package in.co.sunrays.struts.controller;

import java.util.List;

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
public class MarksheetListAction extends ActionSupport {

	private long[] ids;

	/**
	 * RollNo of Student
	 */
	private String rollNo;

	/**
	 * ID of Student
	 */

	private long studentId = 0;
	/**
	 * Name of Student
	 */
	private String name;

	private String operation;

	/**
	 * Page Number
	 */
	private int pageNo = 1;

	private int pageSize = 10;

	private List<MarksheetDTO> list = null;

	/**
	 * Physics marks of Student
	 */

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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<MarksheetDTO> getList() {
		return list;
	}

	public void setList(List<MarksheetDTO> list) {
		this.list = list;
	}
	
	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	/**
	 * Contains display logic. Gets a Marksheet for update if primary key id is
	 * given.
	 */

	public String input() {

		MarksheetModelInt model = ModelFactory.getInstance()
				.getMarksheetModel();

		MarksheetDTO dto = new MarksheetDTO();

		list = model.search(dto, pageNo, pageSize);

		return INPUT;
	}

	/**
	 * Contains submit logic. It adds or updates a Marksheet.
	 */
	public String execute() {

		MarksheetDTO dto = new MarksheetDTO();
		dto.setRollNo(rollNo);
		dto.setName(name);
		dto.setStudentId(studentId);

		MarksheetModelInt model = ModelFactory.getInstance()
				.getMarksheetModel();

		if ("Next".equals(operation)) {
			pageNo++;
		} else if ("Previous".equals(operation)) {
			pageNo--;
		} else if ("Search".equals(operation)) {
			pageNo = 1;
		} else if ("Delete".equals(operation)) {
			for (long id : ids) {
				MarksheetDTO dtoD = new MarksheetDTO();
				dtoD.setId(id);
				model.delete(dtoD);
			}
			pageNo = 1;
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}

		list = model.search(dto, pageNo, pageSize);

		return SUCCESS;
	}
}
