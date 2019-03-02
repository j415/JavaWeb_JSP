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
		/* 数据库中执行 定义过程
		 * CREATE PROCEDURE addTwoNum(in num1 int, in num2 int, out result int)
		 *  BEGIN
		 * set result = num1+num2; 
		 * END;
		 */
		Connection connection = null;
		CallableStatement cstmt = null;
		try {
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");	// 加载具体的驱动类
			// b.与数据库建立连接
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			
			
			
			 cstmt = connection.prepareCall("{ call addTwoNum(?,?,?) }" );
			 cstmt.setInt(1, 20);
			 cstmt.setInt(2, 50);
			 //设置输出参数的类型
			 cstmt.registerOutParameter(3, Types.INTEGER);
			 
			 cstmt.execute();// num1+num2,execute()之前处理输入参数，之后输出参数
			 
			 int result = cstmt.getInt(3);// 获取计算结果
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
				if(cstmt!=null) cstmt.close();	// 对象，方法
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
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");	// 加载具体的驱动类
			// b.与数据库建立连接
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			
			
			
			 cstmt = connection.prepareCall("{? = call addTwoNumFunction(?,?) }" );
			 cstmt.setInt(2, 20);
			 cstmt.setInt(3, 50);
			 //设置输出参数的类型
			 cstmt.registerOutParameter(1, Types.INTEGER);
			 
			 cstmt.execute();// num1+num2,execute()之前处理输入参数，之后输出参数
			 
			 int result = cstmt.getInt(3);// 获取计算结果
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
				if(cstmt!=null) cstmt.close();	// 对象，方法
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
