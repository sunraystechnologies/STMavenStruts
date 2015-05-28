package in.co.sunrays.struts.controller;

import java.util.List;

/**
 * Base List class of project. It contain attributes for List Action Classes.
 * 
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
public abstract class BaseListAction extends BaseAction {

	/**
	 * List Attributes
	 */
	protected List dtoList;
	protected long[] ids;
	protected int pageNo = 1;
	protected int pageSize = 10;

	public List getDtoList() {
		return dtoList;
	}

	public void setDtoList(List dtoList) {
		this.dtoList = dtoList;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
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

}