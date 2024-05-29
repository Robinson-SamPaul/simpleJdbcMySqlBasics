package com.sam.project;

import java.util.List;

import com.sam.project.dao.StudentDao;
import com.sam.project.model.Student;

public class Main {

	public static void main(String[] args) throws Exception {	
		
		StudentDao studentDao = StudentDao.getStudentDao();
		
		/* Get All */
		try {
			List<Student> students = studentDao.getAllStudents();
			System.out.println(students);
		} catch (Exception e) {
			System.err.println("Students not found");
		}
		
		/* Get By ID */
		try {
			Student student = studentDao.getStudentById(7);
			System.out.println(student);
		} catch (Exception e) {
			System.err.println("Student not found");
		}
		
		/* Add one */
		try {
			studentDao.addStudent(7, "Jack");
		} catch (Exception e) {
			System.err.println("Student can't be inserted");
		}
		
		/* Update one */
		try {
			studentDao.updateStudent(7, "Jake");
		} catch (Exception e) {
			System.err.println("Student can't be updated");
		}
		
		/* Delete One */
		try {
			studentDao.deleteStudent(7);
		} catch (Exception e) {
			System.err.println("Student can't be deleted");
		}
	}
}
