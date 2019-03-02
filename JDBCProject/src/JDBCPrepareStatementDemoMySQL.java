import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPrepareStatementDemoMySQL {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
//		invokeProcedure();
	    invokeFunction();

	}
	private static final String URL = "jdbc:mysql://localhost:3306/testdata";
	private static final String USERNAME = "root";
	private static final String PWD = "15111202020";
	
	public static void invokeProcedure() {
		/* ���ݿ���ִ�� �������
		 * CREATE PROCEDURE addTwoNum(in num1 int, in num2 int, out result int)
		 *  BEGIN
		 * set result = num1+num2; 
		 * END;
		 */
		Connection connection = null;
		CallableStatement cstmt = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			
			
			
			 cstmt = connection.prepareCall("{ call addTwoNum(?,?,?) }" );
			 cstmt.setInt(1, 20);
			 cstmt.setInt(2, 50);
			 //�����������������
			 cstmt.registerOutParameter(3, Types.INTEGER);
			 
			 cstmt.execute();// num1+num2,execute()֮ǰ�������������֮���������
			 
			 int result = cstmt.getInt(3);// ��ȡ������
			 System.out.println("result:  "+result);
			 
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(cstmt!=null) cstmt.close();	// ���󣬷���
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void invokeFunction() {
		Connection connection = null;
		CallableStatement cstmt = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			
			
			
			 cstmt = connection.prepareCall("{? = call addTwoNumFunction(?,?) }" );
			 cstmt.setInt(2, 20);
			 cstmt.setInt(3, 50);
			 //�����������������
			 cstmt.registerOutParameter(1, Types.INTEGER);
			 
			 cstmt.execute();// num1+num2,execute()֮ǰ�������������֮���������
			 
			 int result = cstmt.getInt(3);// ��ȡ������
			 System.out.println("result:  "+result);
			 
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(cstmt!=null) cstmt.close();	// ���󣬷���
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
