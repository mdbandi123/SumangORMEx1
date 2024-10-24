package org.acumen.training.codes.test;

import java.util.List;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.StudentDao;
import org.acumen.training.codes.model.Student;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestStudentDao {
	private static final Logger LOGGER = Logger.getLogger(TestStudentDao.class);
	private UnivConfiguration cfg;

	private Student createStudent(String id, String name, String deptName, 
									Integer totCred) {
		Student data = new Student();
		
		data.setId(id);
		data.setName(name);
		data.setDeptName(deptName);
		data.setTotCred(totCred);
		
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
	public void testInsertStudent() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		StudentDao dao = new StudentDao(sf);

		dao.insertStudent(createStudent("00001", "Sumang", "Comp. Sci.", 100));
		dao.insertStudent(createStudent("00002", "Kongo", "Music", 89));
		dao.insertStudent(createStudent("10002", "Park", "Aviation", 101));
		LOGGER.info("testInsertStudent() executed");
	}
	
	@Test
	public void testFindStudent() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		StudentDao dao = new StudentDao(sf);
		
		Student data = dao.findStudent("00002");
		
		System.out.println(data.toString());
		LOGGER.info("testFindStudent() executed");
	}
	
	@Test
	public void testFindStudentPerCourse() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		StudentDao dao = new StudentDao(sf);
		
		List<Student> data = dao.findStudentPerCourse("Music");
		
		System.out.println(data.toString());
		LOGGER.info("testFindStudentPerCourse executed");
	}
}
