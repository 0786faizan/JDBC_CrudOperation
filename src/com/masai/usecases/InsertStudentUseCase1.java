package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

public class InsertStudentUseCase1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter roll");
		int roll= sc.nextInt();
		
		System.out.println("Enter name");
		String name= sc.next();
		
		System.out.println("Enter address");
		String address= sc.next();
		
		System.out.println("Enter marks");
		int marks= sc.nextInt();
		
		
		StudentDao dao = new StudentDaoImpl();
		//StudentDaoImpl dao = new StudentDaoImpl();
		//String msg= dao.insertStudentDetails(roll, name, address, marks);
		//System.out.println(msg);
		
		//Student student = new Student(roll, name, marks, address);
		
		Student student = new Student();
		student.setAddress(address);
		student.setRoll(roll);
		student.setName(name);
		student.setMarks(marks);
		
		
		
		String msg= dao.insertStudentDetails2(student);

		System.out.println(msg);
	}

}
