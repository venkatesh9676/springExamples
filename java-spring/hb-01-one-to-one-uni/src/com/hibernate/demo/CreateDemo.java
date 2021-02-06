package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create sessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			/*
			 * Instructor tempInstructor = new Instructor("chad","Darby","darby@gmail.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("http://www.luv2code.com/youtube", "luv code");
			 */
			Instructor tempInstructor = new Instructor("venky", "sigi", "sigi@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.venkatesh.com/youtube", "practicecode");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start the transaction
			session.beginTransaction();

			// save the instructor
			// note: this will ALSO save the details object
			// because of cascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			System.out.println("commit");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			factory.close();
		}

	}

}
