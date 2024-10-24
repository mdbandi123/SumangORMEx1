package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.acumen.training.codes.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CourseDao {
	private static final Logger LOGGER = Logger.getLogger(CourseDao.class);
	private SessionFactory sf;
	
	public CourseDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	public boolean insertCourse(Course course) {
		LOGGER.info("executing insertCourse()...");
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		try {
			sess.persist(course);
			txn.commit();

			LOGGER.info("insertCourse() executed successfully");
			return true;
		} catch (Exception e) {
			try {
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("caught an exception insertCourse(): %s"
						.formatted(ee.getMessage()));
				ee.printStackTrace();
			}
			LOGGER.error("caught an exception insertCourse(): %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		} finally {
			try {
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("caught an exception insertCourse(): %s"
						.formatted(eee.getMessage()));
				eee.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Course> findCourses(Integer credits) {
		List<Course> recs = new ArrayList<>();

		try (Session sess = sf.openSession();) {
			
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Course> sql = builder.createQuery(Course.class);
			Root<Course> from = sql.from(Course.class);
			sql.select(from).where(builder.equal(from.get("credits"), credits));

			Query<Course> query = sess.createQuery(sql);
			recs = query.getResultList();

			return Collections.unmodifiableList(recs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recs;
	}
}
