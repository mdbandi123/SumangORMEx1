package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.List;

import org.acumen.training.codes.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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
	
	public Student findStudent(String id) {
		LOGGER.info("executing findStudent()...");
		Student rec = new Student();
		
		try (Session sess = sf.openSession();) {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Student> sql = builder.createQuery(Student.class);
			Root<Student> from = sql.from(Student.class);
			
			sql.select(from).where(builder.equal(from.get("id"), id));

			Query<Student> query = sess.createQuery(sql);
			
			LOGGER.info("findStudent() executed successfully");
			return rec = query.getSingleResult();
		} catch (Exception e) {
			LOGGER.error("caught an exception findStudent(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		}
		return rec;
	}
	
	public List<Student> findStudentPerCourse(String course) {
		LOGGER.info("executing findStudentPerCourse()...");
		List<Student> recs = new ArrayList<>();
		
		try (Session sess = sf.openSession();) {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Student> sql = builder.createQuery(Student.class);
			Root<Student> from = sql.from(Student.class);
			
			sql.select(from).where(builder.equal(from.get("deptName"), course));

			Query<Student> query = sess.createQuery(sql);
			
			LOGGER.info("findStudentPerCourse() executed successfully");
			return recs = query.getResultList();
		} catch (Exception e) {
			LOGGER.error("caught an exception findStudentPerCourset(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		}
		return recs;
	}
}
