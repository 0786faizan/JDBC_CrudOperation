package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exceptions.StudentException;

public class GetMarksUseCase {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter roll");
		int roll= sc.nextInt();

		StudentDao dao = new StudentDaoImpl();
		
		
		try {
			int marks = dao.getMarksByRoll(roll);
			
			System.out.println("Student marks is :"+marks);
			
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	}

}
