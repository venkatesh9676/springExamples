package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();	
	   
		//create Session 
		Session session =factory.getCurrentSession();
		
		try {
			int studentId =6;
			
			// new get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting stuent with id: "+studentId);
			Student myStudent =session.get(Student.class, studentId);
			System.out.println("updating student : "+ myStudent);
			myStudent.setFirstName("lakki");
			
			//commit the transaction	
			session.getTransaction().commit();
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("update email for all students");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit the transaction	
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
			
	}

}
