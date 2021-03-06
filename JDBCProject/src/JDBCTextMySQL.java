import java.sql.Statement;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTextMySQL {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 TextDemo();
		clobReadDemo();

	}
	private static final String URL = "jdbc:mysql://localhost:3306/testdata";
	private static final String USERNAME = "root";
	private static final String PWD = "15111202020";
	
	// 通过JDBC存储大文本数据(小说)TEXT
	public static void TextDemo() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");	// 加载具体的驱动类
			// b.与数据库建立连接
			connection = DriverManager.getConnection(URL,USERNAME,PWD);

			String sql = "insert into mynovel values(?,?)";
			
			
			// c.发送sql，执行(增删改、查)
			pstmt =  connection.prepareStatement(sql);
			pstmt.setInt(1, 2);
			File file = new File("D:\\all-workspace\\JavaWeb_JSP\\textdemo.txt");
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in, "UTF-8");// 转换流 可以设置编码
//			pstmt.setCharacterStream(2, reader,  (int)file.length());
			pstmt.setCharacterStream(2, reader, 14000);
			
//			pstmt.setString(2, "D:\\all-workspace\\JavaWeb_JSP\\小说.txt");

			int count = pstmt.executeUpdate();
			
			
			if (count>0) {
				System.out.println("操作成功。");
			}
			
		reader.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();	// 对象，方法
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void clobReadDemo() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");	// 加载具体的驱动类
			// b.与数据库建立连接
			connection = DriverManager.getConnection(URL,USERNAME,PWD);

			String sql = "select NOVEL from mynovel where id = ? ";
			
			
			// c.发送sql，执行(查)
			pstmt =  connection.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.execute();
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Reader reader =  rs.getCharacterStream("NOVEL");
				Writer writer = new FileWriter("src/小说.txt");
				
				char[] chs = new char[100];
				int len = -1;
				while( (len = reader.read(chs))!= -1) {
					writer.write(chs,0,len);
				}
				writer.close();
				reader.close();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();	// 对象，方法
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
