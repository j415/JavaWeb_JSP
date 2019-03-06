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
	
	//����ѧ���޸�ѧ��������sno֪��Ҫ�޸ĵ��ˣ���������޸ĳ�student
	public boolean updateStudentBySno(int sno,Student student) ;
	
	// ����ѧ��ɾѧ��
	public boolean deleteStudentBySno(int sno) ;
	
	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents() ;
	
	
	// ��ѯ�����Ƿ����
	public boolean isExist(int sno);
	
	
	// ����ѧ�Ų�ѧ��
	public Student queryStudentBySno(int sno);
}
