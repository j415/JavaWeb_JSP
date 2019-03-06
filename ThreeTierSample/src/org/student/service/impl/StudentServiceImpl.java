package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;
// 业务逻辑层：逻辑性的增删改查（增：查+增），对Dao层进行组装
public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao = new StudentDaoImpl();
	
	
	// 查询全部学生
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	// 根据学号查学生
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	
	// 改
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}else {
			return false;
		}
	}
	
	// 删
	public boolean deleteStudent(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}else {
			return false;
		}
	}
	
	// 增
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {// 不存在
			studentDao.addStudent(student);
			return true;
		}else{
			System.out.println("此人已存在");
			return false;
			
		}
	}

}
