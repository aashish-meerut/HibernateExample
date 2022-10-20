package com.aashish.hibernate.enterprise.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Util {
	public static  Session giveSession()
    {
		Session session= null;
        //Reading the hibernate configuration file
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder regBuilber = new StandardServiceRegistryBuilder();
		
		
		
		
        regBuilber.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = regBuilber.build();
        
        //Create SessionFacctory
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		
		
		
        
        //Create Session from SessionFactory
        session = sessionFactory.openSession();
        return session;

    }

}
