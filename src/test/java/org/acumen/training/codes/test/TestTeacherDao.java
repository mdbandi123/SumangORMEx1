package org.acumen.training.codes.test;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.TeacherDao;
import org.acumen.training.codes.model.Instructor;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestTeacherDao {
	private static final Logger LOGGER = Logger.getLogger(TestClassroomDao.class);
	private UnivConfiguration cfg;

	private Instructor createInstructor(String id, String name, String deptName, Double salary) {
		Instructor data = new Instructor();
		
		data.setId(id);
		data.setName(name);
		data.setDeptName(deptName);
		data.setSalary(salary);

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
	
	@Disabled
	@Test
	public void testUpdateSalary() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);

		dao.updateSalary("12121", 65000.0);
		LOGGER.info("testUpdateSalary() executed");
	}
}
