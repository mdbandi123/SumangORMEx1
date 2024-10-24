package org.acumen.training.codes.test;

import java.util.List;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.StudentDao;
import org.acumen.training.codes.dao.TeacherDao;
import org.acumen.training.codes.model.Instructor;
import org.acumen.training.codes.model.Student;
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
	
	@Disabled
	@Test
	public void testDeleteInstructor() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);

		dao.deleteInstructor("12345");
		LOGGER.info("testUpdateSalary() executed");
	}
	
	@Disabled
	@Test
	public void testInsertInstructor() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);
		
		dao.insertInstructor(createInstructor("12345","Sumang","Music",65000.00));
		dao.insertInstructor(createInstructor("21222","Walter","Comp. Sci.",75000.00));
		dao.insertInstructor(createInstructor("01012","Smith","Aviation",75000.00));
		LOGGER.info("testInsertInstructor() executed");
	}
	
	@Test
	public void testFindInstructor() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);
		
		List<Instructor> data = dao.findInstructor("Music");
		
		System.out.println(data.toString());
		LOGGER.info("testFindInstructor() executed");
	}
}
