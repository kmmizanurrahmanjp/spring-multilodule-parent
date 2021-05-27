package xyz.mizan.multimodule.comon.util;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class HibernateSession {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(HibernateSession.class);
	
	@Autowired
	EntityManagerFactory factory;

	public SessionFactory getSessionFactory(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return factory.unwrap(SessionFactory.class);
	}

	public Session open() {
		return getSessionFactory(factory).openSession();
	}
}
