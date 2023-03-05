package com.masai.usecases;

import java.util.List;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exceptions.StudentException;

public class GetAllStudents {
	
	public static void main(String[] args) {
		
		
		
		StudentDao dao = new StudentDaoImpl();
		
	 	try {
			List<Student> students= dao.getAllStudents();
			
			students.forEach(s -> {
				
				System.out.println("Roll is :"+s.getRoll());
				System.out.println("Name is :"+s.getName());
				System.out.println("Address is :"+s.getAddress());
				System.out.println("Marks is :"+s.getMarks());
				
				System.out.println("==================================");
				
			});
			
			
			
			
			
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
