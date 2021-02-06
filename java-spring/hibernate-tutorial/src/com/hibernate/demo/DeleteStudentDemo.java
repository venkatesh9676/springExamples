package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();	
	   
		//create Session 
		Session session =factory.getCurrentSession();
		
		try {
			int studentId =5;
			
			// new get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			//retrieve student based on the id: primary key
			System.out.println("\ngetting stuent with id: "+studentId);
			Student myStudent =session.get(Student.class, studentId);
			
		
			//delete the student
			/*System.out.println("deleting student "+myStudent);
			session.delete(myStudent);*/
			
			//commit the transaction	
			session.getTransaction().commit();
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("delete student where student id = 7");
			
			session.createQuery("delete from  Student where id=7").executeUpdate();
		
			//commit the transaction	
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally {
			factory.close();
		}
			
	}

}
