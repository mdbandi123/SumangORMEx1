package org.acumen.training.codes.test;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.DepartmentDao;
import org.acumen.training.codes.model.Department;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestDepartmentDao {
	private static final Logger LOGGER = Logger.getLogger(TestDepartmentDao.class);
	private UnivConfiguration cfg;

	private Department createDepartment(String deptName ,String building, 
										Double budget) {
		Department data = new Department();
		
		data.setDeptName(deptName);
		data.setBuilding(building);
		data.setBudget(budget);
		
		return data;
	}

	@BeforeEach()
	public void setup() {
		cfg = new UnivConfiguration();
	}

	@AfterEach()
	public void teardown() {
		cfg = null;
	}

	@Test
	public void testInsertDepartment() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		DepartmentDao dao = new DepartmentDao(sf);

		dao.insertDepartment(createDepartment("Nursing", "Wahl", 80000.00));
		dao.insertDepartment(createDepartment("Psychology", "Taylor", 80000.00));
		dao.insertDepartment(createDepartment("Aviation", "Watson", 80000.00));
		LOGGER.info("testInsertDepartment() executed");
	}
}
