import java.sql.Statement;
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
	
	public static void update() {// 增 删 改
		Connection connection = null;
		Statement stmt = null;
		try {
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");	// 加载具体的驱动类
			// b.与数据库建立连接
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			// c.发送sql，执行(增删改、查)
			stmt =  connection.createStatement();
			// String sql = "insert into student values(1,'zs',23,'s1')";	// 增
			// String sql = "update student set STUNAME='ls' where stuno=1";	// 改
			String sql = "delete from student where stuno=1";			// 删
			// 执行SQL
			int count = stmt.executeUpdate(sql);	// 返回值表示 增删改 几条数据
			// d.处理结果
			if(count > 0) {
				System.out.println("操作成功！");
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
				if(stmt!=null) stmt.close();	// 对象，方法
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void query() {// 增 删 改
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");	// 加载具体的驱动类
			// b.与数据库建立连接
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			// c.发送sql，执行(增删改、查)
			stmt =  connection.createStatement();
			// String sql = "select stuno,stuname from student";			// 查
			String name = "x";
			String sql = "select * from student where stuname like '%"+name+"%' ";			// 查
			// 执行SQL
			rs = stmt.executeQuery(sql);	// 返回值表示 增删改 几条数据
			// d.处理结果
			while(rs.next()) {
				int sno = rs.getInt("stuno");
				String sname = rs.getString("stuname");
				System.out.println(sno+"--"+sname);
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
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();	// 对象，方法
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
