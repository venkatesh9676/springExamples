package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

import com.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create sessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			
			// start the transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId=299;
			InstructorDetail tempInstructrorDetail =session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInstructor:" +tempInstructrorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor: "+tempInstructrorDetail.getInstructor());
			
			// commit transaction
			System.out.println("commit");
			session.getTransaction().commit();
			System.out.println("Done!!");

		}catch (Exception exe) {
			exe.printStackTrace();
			
		} 
		finally {
			session.close();
			factory.close();
		}

	}

}
