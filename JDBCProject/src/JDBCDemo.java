import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		update();

	}
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USERNAME = "scott";
	private static final String PWD = "tiger";
	
	public static void update() {// �� ɾ ��
		Connection connection = null;
		java.sql.Statement stmt = null;
		try {
			// a.�������������ؾ����������
			Class.forName("oracle.jdbc.OracleDriver");	// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			// c.����sql��ִ��(��ɾ�ġ���)
			stmt =  connection.createStatement();
			// String sql = "insert into student values(1,'zs',23,'s1')";	// ��
			// String sql = "update into student values(1,'zs',23,'s1')";	// ��
			String sql = "delete from student where stuno=1";			// ɾ
			// ִ��SQL
			int count = stmt.executeUpdate(sql);	// ����ֵ��ʾ ��ɾ�� ��������
			// d.������
			if(count>0) {
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
				if(connection!= null) connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
