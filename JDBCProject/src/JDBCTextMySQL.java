import java.sql.Statement;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTextMySQL {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TextDemo();
//		query();

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
			pstmt.setInt(1, 1);
//			File file = new File("D:\\all-workspace\\JavaWeb_JSP\\С˵.txt");
//			InputStream in = new FileInputStream(file);
//			Reader reader = new InputStreamReader(in, "GBK");// ת���� �������ñ���
			pstmt.setString(2, "D:\\all-workspace\\JavaWeb_JSP\\С˵.txt");
//			pstmt.setCharacterStream(2, reader,(int)file.length());

			int count = pstmt.executeUpdate();
			
			
			if (count>0) {
				System.out.println("�����ɹ���");
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
	public static void query() {// �� ɾ ��
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			// c.����sql��ִ��(��ɾ�ġ���)
			stmt =  connection.createStatement();
			// String sql = "select stuno,stuname from student";			// ��
//			String name = "x";
			Scanner input = new Scanner(System.in);
			System.out.print("�������û�����");
			String name = input.nextLine();
			System.out.print("���������룺");
			String pwd = input.nextLine();
			String sql = "select count(*) from login where uname='"+name+"' and upwd ='"+pwd+"' ";
//			String sql = "select * from student where stuname like '%"+name+"%' ";			// ��
			// ִ��SQL
			rs = stmt.executeQuery(sql);	// ����ֵ��ʾ ��ɾ�� ��������
			// d.������
			int count = -1;
			if(rs.next()) {
				count = rs.getInt(1);
				if(count>0) {
					System.out.println("��½�ɹ���");
				}else {
					System.out.println("��½ʧ�ܡ�");
				}
			}
			
//			if(rs.next()) {
//				int sno = rs.getInt("stuno");
//				String sname = rs.getString("stuname");
//				System.out.println(sno+"--"+sname);
//			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
