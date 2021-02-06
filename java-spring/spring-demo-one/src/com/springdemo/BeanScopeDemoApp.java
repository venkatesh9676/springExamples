package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuraTION FILE
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check the if they are the same

		boolean result = (theCoach == alphaCoach);

		// print out the result
		System.out.println("pointing location for object: " + result);

		System.out.println("pointing location for theCoach: " + theCoach);
		System.out.println("memory location for alphaCoach: " + alphaCoach);
		
		// close the request
		context.close();
	}

}
