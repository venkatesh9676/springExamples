package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

import com.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		// create sessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			
			// start the transaction
			session.beginTransaction();

			//get instructor by primary key/id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("found Instructor : "+tempInstructor);

			
			//delete Instructor
			if(tempInstructor !=null) {
				System.out.println("deleting: "+tempInstructor);
				
				//note will ALSO delete associated details object
				session.delete(tempInstructor);
			}
			
			// commit transaction
			System.out.println("commit");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			factory.close();
		}

	}

}
