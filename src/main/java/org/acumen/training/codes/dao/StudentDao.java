package org.acumen.training.codes.dao;

import org.acumen.training.codes.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class StudentDao {
	private SessionFactory sf;
	private static final Logger LOGGER = Logger.getLogger(StudentDao.class);

	public StudentDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	public boolean insertStudent(Student stud) {
		LOGGER.info("executing insertStudent()...");
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		try {
			sess.persist(stud);
			txn.commit();

			LOGGER.info("insertStudent() executed successfully");
			return true;
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("caught an exception insertStudent(): %s"
						.formatted(ee.getMessage()));
				ee.printStackTrace();
			}
			LOGGER.error("caught an exception insertStudent(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("caught an exception insertStudent(): %s"
						.formatted(eee.getMessage()));
				eee.printStackTrace();
			}
		}
		return false;
	}
}
