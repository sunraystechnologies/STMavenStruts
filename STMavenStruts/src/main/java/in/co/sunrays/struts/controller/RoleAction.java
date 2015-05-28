/**
 * 
 */
package in.co.sunrays.struts.controller;

import in.co.sunrays.struts.dto.RoleDTO;
import in.co.sunrays.struts.exception.ApplicationException;
import in.co.sunrays.struts.exception.DuplicateRecordException;
import in.co.sunrays.struts.model.ModelFactory;
import in.co.sunrays.struts.model.RoleModelInt;

import org.apache.log4j.Logger;

/**
 * Role functionality Controller. Performs operation for add, update and get
 * Role
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public class RoleAction extends BaseAction {

	private static Logger log = Logger.getLogger(RoleAction.class);
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Performs display operations for RoleAction
	 * 
	 * @return type String
	 * @return INPUT
	 */
	@Override
	public String input() {

		RoleModelInt model = ModelFactory.getInstance().getRoleModel();
		System.out.println("RoleAction.input() Start");

		log.debug("RoleAction.input() Start");
		if (id > 0) {
			try {
				RoleDTO dto = model.findByPK(id);
				if (dto != null) {
					id = dto.getId();
					name = dto.getName();
					description = dto.getDescription();

				}
			} catch (ApplicationException e) {
				log.error("Critical Issue", e);
				addActionError("Critical issue : " + e.getMessage());
			}
		}
		System.out.println("RoleAction.input() End");
		log.debug("RoleAction.input() End");
		return INPUT;
	}

	/**
	 * Populates RoleDTO from Action attributes
	 */
	protected RoleDTO populateDTO(RoleDTO dto) {

		super.populateDTO(dto);
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		return dto;
	}

	/**
	 * Performs submit operations for RoleAction
	 * 
	 * @return type String
	 * @return SUCCESS
	 */
	@Override
	public String execute() {
		log.debug("RoleAction.execute() Start");
		System.out.println("RoleAction.execute() Start");

		try {
			RoleModelInt model = ModelFactory.getInstance().getRoleModel();

			RoleDTO dto = populateDTO(new RoleDTO());

			if (OP_SAVE.equalsIgnoreCase(operation)) {
				if (id > 0) {
					model.update(dto);
					addActionMessage("Data is Updated Successfully");
				} else {
					id = model.add(dto);
					addActionMessage("Data is Successfully added");
				}
			} else if (OP_DELETE.equalsIgnoreCase(operation)) {
				model.delete(dto);
				log.debug("Role Deleted Successfully.");
			}
		} catch (ApplicationException e) {
			log.error("Critical Issue ", e);
			addActionError("System Error " + e.getMessage());
			return INPUT;
		} catch (DuplicateRecordException e) {
			log.error("Name already exist.", e);
			addActionError("Name already exist");
			return INPUT;
		}

		log.debug("RoleAction.execute() End " + operation);
		System.out.println("RoleAction.execute() End " + operation);

		return SUCCESS;
	}

}