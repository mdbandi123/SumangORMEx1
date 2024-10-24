package org.acumen.training.codes.dao;

import org.acumen.training.codes.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class DepartmentDao {
	private static final Logger LOGGER = Logger.getLogger(DepartmentDao.class);
	private SessionFactory sf;

	public DepartmentDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	public boolean insertDepartment(Department dept) {
		LOGGER.info("executing insertDepartment()...");
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		try {
			sess.persist(dept);
			txn.commit();

			LOGGER.info("insertDepartment() executed successfully");
			return true;
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("caught an exception insertDepartment(): %s"
						.formatted(ee.getMessage()));
				ee.printStackTrace();
			}
			LOGGER.error("caught an exception insertDepartment(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("caught an exception insertDepartment(): %s"
						.formatted(eee.getMessage()));
				eee.printStackTrace();
			}
		}
		return false;
	}
}
