package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Student;
import com.masai.exceptions.StudentException;
import com.masai.utility.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String insertStudentDetails(int roll, String name, String adddress, int marks) {
		
		String message = "Not inserted...";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setString(3, adddress);
			ps.setInt(4, marks);
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Inserted successfully..!";
			
			
		} catch (SQLException e) {
		
			message = e.getMessage();
		}
		
		
		
		
		
		return message;
	}

	@Override
	public String insertStudentDetails2(Student student) {
		
		String message = "Not inserted...";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setString(3, student.getAddress());
			ps.setInt(4, student.getMarks());
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Inserted successfully..!";
			
			
		} catch (SQLException e) {
		
			message = e.getMessage();
		}
		
		
		
		
		
		return message;
		
		

	}

	@Override
	public int getMarksByRoll(int roll)throws StudentException {

		int marks = -1;
		

		try(Connection conn = DBUtil.provideConnection()) {
			

		PreparedStatement ps= conn.prepareStatement("select marks from student where roll=?");	
			
		ps.setInt(1, roll);
		
		ResultSet rs= ps.executeQuery();
			
		if(rs.next())
			marks= rs.getInt("marks");
		else
		{
			//StudentException exp = new StudentException("Student does not exist with the roll: "+roll);
			//throw exp;
			
			
			throw new StudentException("Student does not exist with Roll :"+roll);
		}
		
		
			
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new StudentException(e.getMessage());
			
		}
		
		
		return marks;
		
	}

	@Override
	public Student getStudentByRoll(int roll) throws StudentException {
		
		Student student = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from student where roll =?");
			
			ps.setInt(1, roll);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int r= rs.getInt("roll");
				String n= rs.getString("name");
				String a= rs.getString("address");
				int m= rs.getInt("marks");
				
				student = new Student(r, n, m, a);
				
				
			}else
				throw new StudentException("Student does not exist with Roll :"+roll);
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new StudentException(e.getMessage());
		}
		
		
		
		
		
		
		
		return student;
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		
		List<Student> students = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from student");
			ResultSet rs= ps.executeQuery();
			
			
			while(rs.next()) {
				
				int r= rs.getInt("roll");
				String n= rs.getString("name");
				String a= rs.getString("address");
				int m= rs.getInt("marks");
				
				Student student = new Student(r, n, m, a);
				
				students.add(student);
				
			}
			
			if(students.size() <=0)
				throw new StudentException("There is no any Student");
			
			
			
			
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
			
		}
		
	
		
		return students;
		
		
	}

	@Override
	public boolean giveGraceMarksToStudents(int marks) {
		
		boolean flag = false;
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("update student set marks = marks+? where marks < 800");
			
			ps.setInt(1, marks);
			
			int x= ps.executeUpdate();
			
			if(x > 0)
				flag = true;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return flag;
		
	}

	@Override
	public String updateExistingStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
