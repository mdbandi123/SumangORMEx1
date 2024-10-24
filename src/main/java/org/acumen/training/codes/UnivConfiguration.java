package org.acumen.training.codes;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class UnivConfiguration {
	private Configuration cfg;
	private static final Logger LOGGER = 
			Logger.getLogger(UnivConfiguration.class);

	public boolean createConfiguration() {
		LOGGER.info("Executing createConfiguration()");
		
		try {
			cfg = new Configuration().configure();
			
			LOGGER.info("createConfiguration() ran successfully");
			return true;
		} catch (Exception e) {
			LOGGER.error("Exception caught in createConfiguration() %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		}

		return false;
	}

	public SessionFactory getSessionFactory() {
		LOGGER.info("Executing getSessionFactory()");
		
		try {
			SessionFactory sf = cfg.buildSessionFactory();
			
			LOGGER.info("getSessionFactory() ran successfully");
			return sf;
		} catch (Exception e) {
			LOGGER.error("Exception caught in getSessionFactory() %s"
					.formatted(e.getMessage()));
			e.printStackTrace();
		}
		
		return null;
	}
}
