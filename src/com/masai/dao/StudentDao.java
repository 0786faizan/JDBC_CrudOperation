package com.masai.dao;

import java.sql.ResultSet;
import java.util.List;

import com.masai.bean.Student;
import com.masai.exceptions.StudentException;

public interface StudentDao {
	
	public String insertStudentDetails(int roll,String name, String adddress, int marks);
	
	public String insertStudentDetails2(Student student);
	
	public int getMarksByRoll(int roll)throws StudentException;
	
	public Student getStudentByRoll(int roll)throws StudentException;
	
	public List<Student> getAllStudents()throws StudentException;
	
	public boolean giveGraceMarksToStudents(int marks);
	
	public String updateExistingStudent(Student student)throws StudentException;
	
	
	
	
}
