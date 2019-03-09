package org.student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;
// �������ݲ� ԭ���Ե� ��ɾ�ò�
public class StudentDaoImpl implements IStudentDao {
	
	// ����ѧ��
	public boolean addStudent(Student student) {
		String sql = "insert into student(sno, sname, sage, saddress) values(?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.excuteUpdate(sql, params);
			
	}
	//����ѧ���޸�ѧ��������sno֪��Ҫ�޸ĵ��ˣ���������޸ĳ�student
	public boolean updateStudentBySno(int sno,Student student) {
			String sql = "update student set sname =?,sage=?,saddress=? where sno=?" ;
			Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
			return DBUtil.excuteUpdate(sql, params);
	}
	
	// ����ѧ��ɾѧ��
	public boolean deleteStudentBySno(int sno) {
			String sql = "delete from student where sno = ? " ;
			Object[] params = {sno};
			return DBUtil.excuteUpdate(sql, params);
	}
	
	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents() {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			String sql = "select * from student";
			
			rs =  DBUtil.excuteQuery(sql, null);
			
			//rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				students.add(student);
				
			}	

			return students;	
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
//			 try {
//				 if(rs!=null) rs.close();
//				 if(pstmt!=null) pstmt.close();
//				 if(connection!=null) connection.close();
//			 }catch (SQLException e) {
//				 e.printStackTrace();
//			 }catch (Exception e) {
//				 e.printStackTrace();
//			 }
		}
		return students;
		
	}
	
	
	// ��ѯ�����Ƿ����
	public boolean isExist(int sno) {// false:���˲����ڣ�true:���˴���
		return queryStudentBySno(sno)==null? false:true;
	}
	
	
	// ����ѧ�Ų�ѧ��
	public Student queryStudentBySno(int sno) {
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "select * from student where sno=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				
			}	

			return student;	
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 if(rs!=null) rs.close();
				 if(pstmt!=null) pstmt.close();
				 if(connection!=null) connection.close();
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}
		return student;
		
	}

}
