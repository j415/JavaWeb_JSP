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
			pstmt.setInt(1, 1);
//			File file = new File("D:\\all-workspace\\JavaWeb_JSP\\小说.txt");
//			InputStream in = new FileInputStream(file);
//			Reader reader = new InputStreamReader(in, "GBK");// 转换流 可以设置编码
			pstmt.setString(2, "D:\\all-workspace\\JavaWeb_JSP\\小说.txt");
//			pstmt.setCharacterStream(2, reader,(int)file.length());

			int count = pstmt.executeUpdate();
			
			
			if (count>0) {
				System.out.println("操作成功。");
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
//			String name = "x";
			Scanner input = new Scanner(System.in);
			System.out.print("请输入用户名：");
			String name = input.nextLine();
			System.out.print("请输入密码：");
			String pwd = input.nextLine();
			String sql = "select count(*) from login where uname='"+name+"' and upwd ='"+pwd+"' ";
//			String sql = "select * from student where stuname like '%"+name+"%' ";			// 查
			// 执行SQL
			rs = stmt.executeQuery(sql);	// 返回值表示 增删改 几条数据
			// d.处理结果
			int count = -1;
			if(rs.next()) {
				count = rs.getInt(1);
				if(count>0) {
					System.out.println("登陆成功！");
				}else {
					System.out.println("登陆失败。");
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
				if(stmt!=null) stmt.close();	// 对象，方法
				if(connection!= null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
