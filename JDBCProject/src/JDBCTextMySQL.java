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
	
	// ͨ��JDBC�洢���ı�����(С˵)TEXT
	public static void TextDemo() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);

			String sql = "insert into mynovel values(?,?)";
			
			
			// c.����sql��ִ��(��ɾ�ġ���)
			pstmt =  connection.prepareStatement(sql);
			pstmt.setInt(1, 2);
			File file = new File("D:\\all-workspace\\JavaWeb_JSP\\textdemo.txt");
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in, "UTF-8");// ת���� �������ñ���
//			pstmt.setCharacterStream(2, reader,  (int)file.length());
			pstmt.setCharacterStream(2, reader, 14000);
			
//			pstmt.setString(2, "D:\\all-workspace\\JavaWeb_JSP\\С˵.txt");

			int count = pstmt.executeUpdate();
			
			
			if (count>0) {
				System.out.println("�����ɹ���");
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
				if(pstmt!=null) pstmt.close();	// ���󣬷���
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
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);

			String sql = "select NOVEL from mynovel where id = ? ";
			
			
			// c.����sql��ִ��(��)
			pstmt =  connection.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.execute();
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Reader reader =  rs.getCharacterStream("NOVEL");
				Writer writer = new FileWriter("src/С˵.txt");
				
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
				if(pstmt!=null) pstmt.close();	// ���󣬷���
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}