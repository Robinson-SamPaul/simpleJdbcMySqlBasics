package com.sam.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.sam.project.model.Student;
import com.sam.project.util.DbConnectivity;

public class StudentDao {
	
	private static StudentDao studentDao = null;
	
	public static StudentDao getStudentDao() {
		if (Objects.isNull(studentDao)) {
			studentDao = new StudentDao();
		}
		return studentDao;
	}
	
	public Student getStudentById(int id) {
		Student student = fetchStudentById(id);
		if(Objects.isNull(student)) {
			throw new RuntimeException();
		}
		return student;
	}
	
	public void addStudent(int id, String name) throws SQLException {
		insertNewStudent(id, name);
	}
	
	public void updateStudent(int id, String name) throws SQLException {
		editStudentById(id, name);
	}
	
	public List<Student> getAllStudents() {
		List<Student> students = fetchAllStudents();
		if(students.isEmpty()) {
			throw new RuntimeException();
		}
		return students;
	}
	
	private List<Student> fetchAllStudents() {
		
		String query = "SELECT * FROM STUDENT";
		List<Student> students = new ArrayList<>();
		
		try (ResultSet resultSet = DbConnectivity.getResultSet(query)) {
			
			while(resultSet.next()) {
				students.add(new Student(resultSet.getInt(1), resultSet.getString(2)));
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		return students;
	}
	
	private Student fetchStudentById(int id) {
		
		String query = "SELECT * FROM STUDENT WHERE ID = " + id;
		Student student = null;
		
		try (ResultSet resultSet = DbConnectivity.getResultSet(query)) {
			
			if(resultSet.next()) {
				student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		return student;
	}

	private void editStudentById(int id, String name) throws SQLException {
		
		String query = "UPDATE STUDENT SET name = ? WHERE id = ?";

		PreparedStatement statement = DbConnectivity.getPreparedStatement(query);
	
		statement.setInt(2, id);
		statement.setString(1, name);
		
		statement.executeUpdate();
		
		statement.close();
	}
	
	private void insertNewStudent(int id, String name) throws SQLException {
		
		String query = "INSERT into STUDENT VALUES (?, ?)";

		PreparedStatement statement = DbConnectivity.getPreparedStatement(query);
	
		statement.setInt(1, id);
		statement.setString(2, name);
		
		statement.executeUpdate();
		
		statement.close();
	}

	public void deleteStudent(int id) throws SQLException {
		
		String query = "DELETE FROM STUDENT WHERE id = ?";

		PreparedStatement statement = DbConnectivity.getPreparedStatement(query);
	
		statement.setInt(1, id);
		
		statement.executeUpdate();
		
		statement.close();
		
	}
}
