package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("josh","sigi","venky@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student...");
			session.save(tempStudent);
			System.out.println("save");
			
			//commit transaction
			System.out.println("commit");
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
			
	}

}
