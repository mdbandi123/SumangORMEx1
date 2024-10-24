package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.acumen.training.codes.UnivConfiguration;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUnivConfiguration {
	private static final Logger LOGGER = Logger.getLogger(TestUnivConfiguration.class);
	private UnivConfiguration cfg;
	
	@BeforeEach()
	public void setup() {
		cfg = new UnivConfiguration();
	}
	
	@AfterEach()
	public void teardown() {
		cfg = null;
	}
	
	@Test
	public void testUnivConfiguration() {
		LOGGER.info("executing testUnivConfiguration()");
		assertEquals(true,cfg.createConfiguration());
		assertNotNull(cfg.getSessionFactory());
		LOGGER.info("testUnivConfiguration() executed");
	}
}
