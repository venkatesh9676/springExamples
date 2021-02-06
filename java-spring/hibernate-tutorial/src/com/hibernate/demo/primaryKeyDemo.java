package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class primaryKeyDemo {

	public static void main(String[] args) {
		//create sessionFactory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();	
			   
				//create Session 
				Session session =factory.getCurrentSession();
				
				try {
					
					//create 3 student objects
					System.out.println("Creating a new Student object....");
					Student tempStudent1 = new Student("lakki","guthi","lakki@gmail.com");
					Student tempStudent2 = new Student("yas","poli","yaswa@gmail.com");
					Student tempStudent3 = new Student("kusi","poli","kusi@gmail.com");
					//start the transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the Student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					System.out.println("save sucessfully");
					
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
