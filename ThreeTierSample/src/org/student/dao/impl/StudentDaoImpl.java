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
// 访问数据层 原子性的 增删该查
public class StudentDaoImpl implements IStudentDao {
	
	// 增加学生
	public boolean addStudent(Student student) {
		String sql = "insert into student(sno, sname, sage, saddress) values(?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.excuteUpdate(sql, params);
			
	}
	//根据学好修改学生：根据sno知道要修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno,Student student) {
			String sql = "update student set sname =?,sage=?,saddress=? where sno=?" ;
			Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
			return DBUtil.excuteUpdate(sql, params);
	}
	
	// 根据学号删学生
	public boolean deleteStudentBySno(int sno) {
			String sql = "delete from student where sno = ? " ;
			Object[] params = {sno};
			return DBUtil.excuteUpdate(sql, params);
	}
	
	// 查询全部学生
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
	
	
	// 查询此人是否存在
	public boolean isExist(int sno) {// false:此人不存在，true:此人存在
		return queryStudentBySno(sno)==null? false:true;
	}
	
	
	// 根据学号查学生
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
