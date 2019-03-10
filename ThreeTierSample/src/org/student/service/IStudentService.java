package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	
	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents();
	
	// ����ѧ�Ų�ѧ��
	public Student queryStudentBySno(int sno);
	
	// ��ѯ��ǰҳ�����ݼ���
	public List<Student> queryStudentsByPage(int currentPage,int pageSize);
	
	
	public int getTotalCount();
	
	// ��
	public boolean updateStudentBySno(int sno,Student student);
	
	// ɾ
	public boolean deleteStudent(int sno);
	
	// ��
	public boolean addStudent(Student student);

}
