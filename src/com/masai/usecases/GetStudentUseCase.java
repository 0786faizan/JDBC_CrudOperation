
package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Student;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exceptions.StudentException;

public class GetStudentUseCase {
	
	
	public static void main(String[] args) {
		
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter roll");
		int roll= sc.nextInt();

		StudentDao dao = new StudentDaoImpl();
		
		
		try {
			Student student= dao.getStudentByRoll(roll);
			
			
			System.out.println(student);
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}
