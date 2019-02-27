import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemoMySQL {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// update();
		query();

	}
	private static final String URL = "jdbc:mysql://localhost:3306/testdata";
	private static final String USERNAME = "root";
	private static final String PWD = "15111202020";
	
	public static void update() {// �� ɾ ��
		Connection connection = null;
		Statement stmt = null;
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			// c.����sql��ִ��(��ɾ�ġ���)
			stmt =  connection.createStatement();
			// String sql = "insert into student values(1,'zs',23,'s1')";	// ��
			// String sql = "update student set STUNAME='ls' where stuno=1";	// ��
			String sql = "delete from student where stuno=1";			// ɾ
			// ִ��SQL
			int count = stmt.executeUpdate(sql);	// ����ֵ��ʾ ��ɾ�� ��������
			// d.������
			if(count > 0) {
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
				if(stmt!=null) stmt.close();	// ���󣬷���
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
