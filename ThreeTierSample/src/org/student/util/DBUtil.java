package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

// 通用的数据操作方法
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/testdata";
	private static final String USERNAME = "root";
	private static final String PWD = "15111202020";
	
	
	// 通用的增删改
	public static boolean excuteUpdate(String sql,Object[] params) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			
			
			// Object obj = {name,age,.connection ...};
			// String sql = "delete from student where sno = ? " ;
			 pstmt = connection.prepareStatement(sql);
			// pstmt.setInt(1, sno);
			 for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
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
	
	// 通用的查：返回值是一个集合 （Student，List<Students>,null）
	public ResultSet queryAllStudents(String sql,Object[] params) {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			
			// String sql = "select * from student";
			pstmt = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			rs = pstmt.executeQuery();
				

//			return rs;	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		finally {
//			 try {
//				 if(rs!=null) rs.close();
//				 if(pstmt!=null) pstmt.close();
//				 if(connection!=null) connection.close();
//			 }catch (SQLException e) {
//				 e.printStackTrace();
//			 }catch (Exception e) {
//				 e.printStackTrace();
//			 }
//		}
		return rs;
		
	}
}
