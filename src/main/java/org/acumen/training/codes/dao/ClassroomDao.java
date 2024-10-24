package org.acumen.training.codes.dao;

import org.acumen.training.codes.model.Classroom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class ClassroomDao {
	private static final Logger LOGGER = Logger.getLogger(ClassroomDao.class);
	private SessionFactory sf;

	public ClassroomDao(SessionFactory sf) {
		this.sf = sf;
	}

	public boolean insertClassroom(Classroom classroom) {
		LOGGER.info("executing insertClassroom()...");
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		try {
			sess.persist(classroom);
			txn.commit();

			LOGGER.info("insertClassroom() executed successfully");
			return true;
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("caught an exception insertClassroom(): %s"
						.formatted(ee.getMessage()));
				ee.printStackTrace();
			}
			LOGGER.error("caught an exception insertClassroom(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("caught an exception insertClassroom(): %s"
						.formatted(eee.getMessage()));
				eee.printStackTrace();
			}
		}
		return false;
	}
}
