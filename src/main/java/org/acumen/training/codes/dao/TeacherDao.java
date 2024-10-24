package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.List;

import org.acumen.training.codes.model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
	
	public boolean deleteInstructor(String id) {
		LOGGER.info("executing deleteInstructor()...");
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();

		try {
			Instructor instructor = sess.get(Instructor.class, id); 
			sess.remove(instructor);
			txn.commit();
			LOGGER.info("deleteInstructor() executed successfully");
			return true;
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("caught an exception deleteInstructor(): %s"
						.formatted(ee.getMessage()));
				ee.printStackTrace();
			}
			LOGGER.error("caught an exception deleteInstructor(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("caught an exception deleteInstructor(): %s"
						.formatted(eee.getMessage()));
				eee.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean insertInstructor(Instructor instructor) {
		LOGGER.info("executing insertInstructor()...");
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		try {
			sess.persist(instructor);
			txn.commit();

			LOGGER.info("insertInstructor() executed successfully");
			return true;
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("caught an exception insertInstructor(): %s"
						.formatted(ee.getMessage()));
				ee.printStackTrace();
			}
			LOGGER.error("caught an exception insertInstructor(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("caught an exception insertInstructor(): %s"
						.formatted(eee.getMessage()));
				eee.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Instructor> findInstructor(String course) {
		LOGGER.info("executing findInstructor()...");
		List<Instructor> recs = new ArrayList<>();
		
		try (Session sess = sf.openSession();) {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Instructor> sql = builder.createQuery(Instructor.class);
			Root<Instructor> from = sql.from(Instructor.class);
			
			sql.select(from).where(builder.equal(from.get("deptName"), course));

			Query<Instructor> query = sess.createQuery(sql);
			
			LOGGER.info("findInstructor() executed successfully");
			return recs = query.getResultList();
		} catch (Exception e) {
			LOGGER.error("caught an exception findInstructor(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		}
		return recs;
	}
}
