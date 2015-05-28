package in.co.sunrays.struts.controller;

import in.co.sunrays.struts.dto.RoleDTO;
import in.co.sunrays.struts.exception.ApplicationException;
import in.co.sunrays.struts.model.ModelFactory;
import in.co.sunrays.struts.model.RoleModelInt;

import org.apache.log4j.Logger;

/**
 * Role List functionality Controller. Performs operation for list, search
 * operations of Role
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class RoleListAction extends BaseListAction {

	private static Logger log = Logger.getLogger(RoleListAction.class);
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Performs display operations for RoleListAction
	 * 
	 * @return type String
	 * @return INPUT
	 */
	public String input() {

		RoleModelInt model = ModelFactory.getInstance().getRoleModel();

		log.debug("RoleListAction.input() Start");
		try {
			dtoList = model.search(null, pageNo, pageSize);
		} catch (ApplicationException e) {
			log.error("Critical Issue ", e);
			return OP_ERROR;
		}
		log.debug("RoleListAction.input() End");
		return INPUT;
	}

	/**
	 * Performs submit operations for RoleListAction
	 * 
	 * @return type String
	 * @return SUCCESS
	 */
	@Override
	public String execute() {
		log.debug("RoleListAction.execute() Start");
		/**
		 * Set search parameters
		 */
		RoleDTO searchDto = new RoleDTO();
		searchDto.setName(name);

		RoleModelInt model = ModelFactory.getInstance().getRoleModel();

		try {
			if (OP_DELETE.equalsIgnoreCase(operation) && ids != null) {
				RoleDTO deleteDTO = new RoleDTO();
				for (int i = 0; i < ids.length; i++) {
					deleteDTO.setId(ids[i]);
					model.delete(deleteDTO);
					pageNo = 1;
				}
			} else if ("Next".equalsIgnoreCase(operation)) {
				pageNo++;
			} else if ("Previous".equalsIgnoreCase(operation) && pageNo > 1) {
				pageNo--;
			}
			dtoList = model.search(searchDto, pageNo, pageSize);
			if (dtoList.size() == 0) {
				pageNo--;
				addActionError("No Record Found");
			}
		} catch (ApplicationException e) {
			log.error("Critical Issue ", e);
			return OP_ERROR;
		}
		log.debug("RoleListAction.execute() End " + operation);
		return INPUT;
	}

}