package com.sping.orm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sping.orm.conf.SpringOrmConf;
import com.sping.orm.dao.StudentDaoImpl;
import com.sping.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringOrmConf.class);
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
		StudentDaoImpl studentdaoImpl = context.getBean("studentdaoImpl", StudentDaoImpl.class);
		Student student = new Student();
		student.setId(444);
		student.setName("Sachin");
		student.setMarks("98");
		student.setRollNo("54");
		int insert = studentdaoImpl.insert(student);
		System.out.println("Student inserted in Table " + insert);
		context.close();
	}
}
