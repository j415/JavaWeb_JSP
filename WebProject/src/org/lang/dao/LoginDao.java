package org.lang.dao;
import java.sql.*;

import org.lang.entity.Login;

public class LoginDao {
//	public int login(String name, String pwd) {
	public int login(Login login) {

		String URL = "jdbc:mysql://localhost:3306/testdata";
		String USERNAME = "root";
		String PWD = "15111202020";
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			// c.����sql��ִ��(��)
			stmt =  connection.createStatement();
			
			// select * from login where uname = "aspire" and upwd = "aspire";

			

//			String sql = "select count(*) from login where uname='"+login.getName()+"' and upwd ='"+login.getPwd()+"' " ;

			// select * from login where uname = "aspire" and upwd = "aspire";
			String sql = "select * from login where uname='"+login.getName()+"' and upwd ='"+login.getPwd()+"' " ;
			// ִ��SQL
			rs = stmt.executeQuery(sql);	// ����ֵ��ʾ ��ɾ�� ��������
			// d.������
			int count = -1;
			if(rs.next()) {
				count = rs.getInt(1);

			}
			return count;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();	// ���󣬷���
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
