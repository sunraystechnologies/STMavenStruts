package in.co.sunrays.struts.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.struts.dto.MarksheetDTO;
import in.co.sunrays.struts.exception.ApplicationException;
import in.co.sunrays.struts.exception.DuplicateRecordException;
import in.co.sunrays.struts.model.MarksheetModelInt;
import in.co.sunrays.struts.model.ModelFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MarksheetTestcase {

	static MarksheetModelInt model = null;

	@BeforeClass
	public static void beforeClass() {
		model = ModelFactory.getInstance().getMarksheetModel();
		System.out.println("Model --------------->" + model);
	}

	@AfterClass
	public static void afterClass() {
		model = null;
	}

	@Test
	public void testAdd() {

		try {
			MarksheetDTO dto = new MarksheetDTO();
			dto.setRollNo("7");
			dto.setName(" Marry");
			dto.setPhysics(88);
			dto.setChemistry(77);
			dto.setMaths(99);
			dto.setStudentId(1L);
			long pk = model.add(dto);

			MarksheetDTO addedDto = model.findByPK(pk);
			assertNotNull("Add Fail", addedDto);

		} catch (ApplicationException e) {
		} catch (DuplicateRecordException e) {
			System.out.println("Duplicate RollNumber");
		}

	}

	/**
	 * Tests delete a Marksheet
	 */
	@Test
	public void testDelete() {

		try {
			MarksheetDTO dto = new MarksheetDTO();
			long pk = 8L;
			dto.setId(pk);
			model.delete(dto);
			MarksheetDTO deletedDto = model.findByPK(pk);
			assertNull("Delete Fail", deletedDto);
		} catch (ApplicationException e) {
		}
	}

	/**
	 * Tests update a Marksheet
	 */
	@Test
	public void testUpdate() {

		try {

			MarksheetDTO dto = model.findByPK(3L);
			dto.setName("new");
			dto.setChemistry(88);
			dto.setMaths(88);
			model.update(dto);

			MarksheetDTO updatedDTO = model.findByPK(3L);
			assertEquals("new", updatedDTO.getName());

		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a marksheet by Roll No.
	 */

	@Test
	public void testFindByRollNo() {
		try {
			MarksheetDTO dto = model.findByRollNo("3");

			assertNotNull(dto);

			if (dto != null) {
				System.out.println(dto.getId());
				System.out.println(dto.getRollNo());
				System.out.println(dto.getName());
				System.out.println(dto.getPhysics());
				System.out.println(dto.getChemistry());
				System.out.println(dto.getMaths());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a marksheet by PK.
	 */
	@Test
	public void testFindByPK() {

		try {

			MarksheetDTO dto = null;
			long pk = 3L;
			dto = model.findByPK(pk);

			assertNotNull(dto);

			if (dto != null) {
				System.out.println(dto.getId());
				System.out.println(dto.getRollNo());
				System.out.println(dto.getName());
				System.out.println(dto.getPhysics());
				System.out.println(dto.getChemistry());
				System.out.println(dto.getMaths());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests list of Marksheets
	 */
	@Test
	public void testSearch() {
		try {

			MarksheetDTO dto = new MarksheetDTO();

			List list = model.search(dto);

			assertTrue(list.size() > 0);

			Iterator it = list.iterator();

			while (it.hasNext()) {
				dto = (MarksheetDTO) it.next();
				System.out.println(dto.getId());
				System.out.println(dto.getRollNo());
				System.out.println(dto.getName());
				System.out.println(dto.getPhysics());
				System.out.println(dto.getChemistry());
				System.out.println(dto.getMaths());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests get the meritlist of Marksheets
	 */
	public static void testMeritList() {
		try {
			MarksheetDTO dto = new MarksheetDTO();
			List list = new ArrayList();
			list = model.getMeritList(1, 5);
			assertTrue(list.size() > 0);
			Iterator it = list.iterator();
			while (it.hasNext()) {
				dto = (MarksheetDTO) it.next();
				System.out.println(dto.getId());
				System.out.println(dto.getRollNo());
				System.out.println(dto.getName());
				System.out.println(dto.getPhysics());
				System.out.println(dto.getChemistry());
				System.out.println(dto.getMaths());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getModifiedDatetime());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

}
