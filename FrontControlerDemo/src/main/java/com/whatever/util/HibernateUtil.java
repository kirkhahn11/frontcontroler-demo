package com.whatever.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	private static Session ses; // this gives us methods like save(), get(), load(), delete(),
	
	public static Session getSession() {
	
		if(ses == null) {
			ses = sf.openSession(); // this opens up a JDBC connection to our database
		}
		
		return ses;
	}
	
	public static void closeSession() {
		ses.close();
		sf.close();
	}
}
