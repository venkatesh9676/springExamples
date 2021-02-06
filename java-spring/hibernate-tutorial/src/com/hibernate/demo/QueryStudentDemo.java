package com.hibernate.demo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();	
	   
		//create Session 
		Session session =factory.getCurrentSession();
		
		try {
			
			
			//start the transaction
			session.beginTransaction();
			
			
			//Query Student
			
			List<Student> theStudent = session.createQuery("from Student").list();
			
			//display the student
			displayStudents(theStudent);
			
			
			
			
			//query students: lastname="sravanthi"
			theStudent = session.createQuery("from Student s where s.lastName='poli'").list();
			
			//display the student
			System.out.println("Students who have last name is poli");
			displayStudents(theStudent);
			
			
			
			
			
			//query student : lastname='poli' OR firstname='lakki'
			theStudent = session.createQuery("from Student s where"+" s.lastName='poli' OR s.firstName='lakki'").list();
			
			System.out.println("Students who have lastname='poli' OR firstname='lakki'");
			displayStudents(theStudent);
			
			
			
			
			
			//query students where email LIKE 'lakki@gmail.com'
			theStudent = session.createQuery("from Student s where"+" s.email LIKE '%gmail.com'").list();
			
			System.out.println("Students whose email ends with LIKE '%@gmail.com'");
			displayStudents(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
			
	}

	private static void displayStudents(List<Student> theStudent) {
		for( Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
