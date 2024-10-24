package org.acumen.training.codes.test;

import java.util.List;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.CourseDao;
import org.acumen.training.codes.model.Course;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestCourseDao {
	private static final Logger LOGGER = Logger.getLogger(TestCourseDao.class);
	private UnivConfiguration cfg;

	private Course createCourse(String courseId, String title, String deptName, Integer credits) {
		Course data = new Course();
		
		data.setCourseId(courseId);
		data.setTitle(title);
		data.setDeptName(deptName);
		data.setCredits(credits);

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
	public void testInsertCourse() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		CourseDao dao = new CourseDao(sf);

		dao.insertCourse(createCourse("AVI-104", "Aviation Basics", "Aviation", 2));
		dao.insertCourse(createCourse("MUS-203", "Advanced Jazz Standards", "Music", 4));
		dao.insertCourse(createCourse("ICT-101", "History of Computing", "Comp. Sci.", 4));
		LOGGER.info("testInsertCourse() executed");
	}
	
	@Test
	public void testFindCourses() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		CourseDao dao = new CourseDao(sf);

		List<Course> data = dao.findCourses(4);
		System.out.println(data);
		LOGGER.info("testInsertCourse() executed");
	}
}
