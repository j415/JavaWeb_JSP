package org.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	public boolean addStudent(Student student) ;
	
	//根据学好修改学生：根据sno知道要修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno,Student student) ;
	
	// 根据学号删学生
	public boolean deleteStudentBySno(int sno) ;
	
	// 查询全部学生
	public List<Student> queryAllStudents() ;
	
	
	// 查询此人是否存在
	public boolean isExist(int sno);
	
	
	// 根据学号查学生
	public Student queryStudentBySno(int sno);
}
