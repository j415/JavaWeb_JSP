import java.sql.Statement;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCBlobMySQL {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 blobDemo();
		blobReadDemo();

	}
	private static final String URL = "jdbc:mysql://localhost:3306/testdata";
	private static final String USERNAME = "root";
	private static final String PWD = "15111202020";
	
	// ͨ��JDBC�洢�������ļ���mp3��
	// ����Blog����
	public static void blobDemo() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);

			String sql = "insert into mymusic values(?,?)";
			
			
			// c.����sql��ִ��(��ɾ��)
			pstmt =  connection.prepareStatement(sql);
			pstmt.setInt(1, 1);
			File file = new File("D:\\all-workspace\\JavaWeb_JSP\\music.mp3");
			
			InputStream in = new FileInputStream(file);
			pstmt.setBinaryStream(2, in, 12800);
			

			int count = pstmt.executeUpdate();
			
			
			if (count>0) {
				System.out.println("�����ɹ���");
			}
			in.close();
			
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
	// ��ȡ�������ļ�
	public static void blobReadDemo() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);

			String sql = "select music from mymusic where id = ? ";
			
			
			// c.����sql��ִ��(��)
			pstmt =  connection.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.execute();
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				InputStream in =  rs.getBinaryStream("music");
				OutputStream out = new FileOutputStream("src/jsp_music.mp3");
				
				byte[] bt = new byte[100];
				int len = -1;
				while( (len = in.read(bt))!= -1) {
					out.write(bt,0,len);
				}
				out.close();
				in.close();
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
