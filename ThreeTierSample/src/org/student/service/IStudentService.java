package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	// 查询全部学生
		public List<Student> queryAllStudents();
		
		// 根据学号查学生
		public Student queryStudentBySno(int sno);
		
		// 改
		public boolean updateStudentBySno(int sno,Student student);
		
		// 删
		public boolean deleteStudent(int sno);
		
		// 增
		public boolean addStudent(Student student);

}
