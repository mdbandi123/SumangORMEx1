package org.acumen.training.codes.dao;

import org.acumen.training.codes.model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class TeacherDao {
	private static final Logger LOGGER = Logger.getLogger(TeacherDao.class);
	private SessionFactory sf;

	public TeacherDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	public boolean updateSalary(String id, Double newSalary) {
		LOGGER.info("executing updateSalary()...");
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();

		try {
			Instructor instructor = sess.get(Instructor.class, id); 
			instructor.setSalary(newSalary);
			sess.merge(instructor);
			txn.commit();
			LOGGER.info("updateSalary() executed successfully");
			return true;
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("caught an exception updateSalary(): %s"
						.formatted(ee.getMessage()));
				ee.printStackTrace();
			}
			LOGGER.error("caught an exception updateSalary(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("caught an exception updateSalary(): %s"
						.formatted(eee.getMessage()));
				eee.printStackTrace();
			}
		}
		return false;
	}
}
