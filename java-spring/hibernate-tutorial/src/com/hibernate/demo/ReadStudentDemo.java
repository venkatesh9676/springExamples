package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();	
	   
		//create Session 
		Session session =factory.getCurrentSession();
		
		try {
			
			//create a student object
			System.out.println("Creating a new Student object....");
			Student tempStudent = new Student("chinni","sravanthi","sravya@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			System.out.println("save");
			
			//commit transaction
			session.getTransaction().commit();
			
			// find out the student id: primary key
			System.out.println("saved student Generated id: "+tempStudent.getId());
			
			// new get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting stuent with id: "+tempStudent.getId());
			Student myStudent =session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: "+ myStudent);
			
			//commit the transaction	
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
			
	}

}
