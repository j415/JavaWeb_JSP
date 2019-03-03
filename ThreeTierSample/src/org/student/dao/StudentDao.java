package org.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.student.entity.Student;
// 访问数据层 原子性的 增删该查
public class StudentDao {
	final String URL = "jdbc:mysql://localhost:3306/testdata";
	final String USERNAME = "root";
	final String PWD = "15111202020";
	
	
	public boolean isExist(int sno) {// false:此人不存在，true:此人存在
		return queryStudentBySno(sno)==null? false:true;
	}
	
	
	public boolean addStudent(Student student) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			String sql = "insert into student values(?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSage());
			pstmt.setString(4, student.getSaddress());
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			 try {
				 if(pstmt!=null) pstmt.close();
				 if(connection!=null) connection.close();
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}
	}
	
	// 根据学生查学号
	public Student queryStudentBySno(int sno) {
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			
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
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
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
