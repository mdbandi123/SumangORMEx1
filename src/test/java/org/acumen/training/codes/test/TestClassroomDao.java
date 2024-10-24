package org.acumen.training.codes.test;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.ClassroomDao;
import org.acumen.training.codes.model.Classroom;
import org.acumen.training.codes.model.compositekeys.ClassroomId;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestClassroomDao {
	private static final Logger LOGGER = Logger.getLogger(TestClassroomDao.class);
	private UnivConfiguration cfg;

	private Classroom createClassroom(String building, String roomNumber,
										Integer capacity) {
		ClassroomId idData = new ClassroomId();
		Classroom data = new Classroom();

		idData.setBuilding(building);
		idData.setRoomNumber(roomNumber);

		data.setIds(idData);
		data.setCapacity(capacity);

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
	public void testInsertClassroom() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		ClassroomDao dao = new ClassroomDao(sf);

		dao.insertClassroom(createClassroom("Benjamin", "4322", 50));
		dao.insertClassroom(createClassroom("Parker", "111", 54));
		dao.insertClassroom(createClassroom("Wahl", "420", 30));
		LOGGER.info("testInsertClassroo() executed");
	}

}
