package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

// 通用的数据操作方法
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/testdata";
	private static final String USERNAME = "root";
	private static final String PWD = "15111202020";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	// 查询数据库表中的数量
	public static int getTotalCount(String sql) {
		int count = -1;
		try {
			pstmt =  createPrepareStatement(sql, null);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		return count;
	}
	
	
	// 通用的增删改
	public static boolean excuteUpdate(String sql,Object[] params) {

		try {
			
			// Object obj = {name,age,.connection ...};
			// String sql = "delete from student where sno = ? " ;
			// pstmt.setInt(1, sno);
			
			pstmt = createPrepareStatement(sql, params);
			
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
			 closeAll(null, pstmt, connection);
		}
	}
	
	public static Connection getConnetcion() throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PWD);
		
	}
	public static PreparedStatement createPrepareStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnetcion().prepareStatement(sql);
		if(params!=null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection connection) {
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
	
	
	// 通用的查：返回值是一个集合 （Student，List<Students>, null）
	public static ResultSet excuteQuery(String sql,Object[] params) {
		List<Student> students = new ArrayList<Student>();
		Student student = null;

		try {
			// 获取链接对象

			// String sql = "select * from student";
			pstmt = createPrepareStatement(sql, params);
			
			rs = pstmt.executeQuery();
				

			return rs;	
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
