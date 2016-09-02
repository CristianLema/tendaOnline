package com.sopra.tienda.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.sopra.tienda.interfaces.daos.InterfacesDAO;
import com.sopra.tienda.interfaces.daos.Validable;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {

		try {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			// Log exception!
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}

	}

	// para cada vez que se queira gardar un obxecto
	public void save(Validable o) {
		if (o.isValid())
			this.save(o);
	}

	public static Session getSession() throws HibernateException {
		// Session ss= sessionFactory.openSession();
		// Object metodo=ss.getClass().getMethod("save");

		return sessionFactory.openSession();
	}

	public static void shutdown() {
		// Close caches and connection pools
		sessionFactory.close();
	}
}
