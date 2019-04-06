package org.sdut.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sdut.entity.Login;

public class LoginDao {
	private static final String URL = "jdbc:mysql://localhost:3306/doctor";
	private static final String USERNAME = "root";
	private static final String PWD = "15111202020";
	public static int login(Login login, String selectes) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			if(selectes.equals("admin")) {
				sql = "select * from adminlogin where name=? and pwd=?";
			}else if(selectes.equals("doctor")) {
				sql = "select * from doctorlogin where name=? and pwd=?";
			}else if(selectes.equals("user")) {
				sql = "select * from userlogin where name=? and pwd=?";
			}else {
				System.out.println("meiyou");
			}
			pstmt  = connection.prepareStatement(sql);
			pstmt.setString(1, login.getName());
			pstmt.setString(2, login.getPwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			if(result>0) {
				return 1;
			}else {
				return 0;
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return -1;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
