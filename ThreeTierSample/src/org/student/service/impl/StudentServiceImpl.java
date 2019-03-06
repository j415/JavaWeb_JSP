package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;
// ҵ���߼��㣺�߼��Ե���ɾ�Ĳ飨������+��������Dao�������װ
public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao = new StudentDaoImpl();
	
	
	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	// ����ѧ�Ų�ѧ��
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	
	// ��
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}else {
			return false;
		}
	}
	
	// ɾ
	public boolean deleteStudent(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}else {
			return false;
		}
	}
	
	// ��
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) {// ������
			studentDao.addStudent(student);
			return true;
		}else{
			System.out.println("�����Ѵ���");
			return false;
			
		}
	}

}
