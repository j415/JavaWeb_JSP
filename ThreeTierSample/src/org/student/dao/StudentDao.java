package org.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;
// �������ݲ� ԭ���Ե� ��ɾ�ò�
public class StudentDao {
	final String URL = "jdbc:mysql://localhost:3306/testdata";
	final String USERNAME = "root";
	final String PWD = "15111202020";
	
	

	
	// ����ѧ��
	public boolean addStudent(Student student) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			String sql = "insert into student values(?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSage());
			pstmt.setString(4, student.getSaddress());
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			 try {
				 if(pstmt!=null) pstmt.close();
				 if(connection!=null) connection.close();
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}
	}
	
	//����ѧ���޸�ѧ��������sno֪��Ҫ�޸ĵ��ˣ���������޸ĳ�student
	public boolean updateStudentBySno(int sno,Student student) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			String sql = "update student set sname =?,sage=?,saddress=? where sno=?" ;
			pstmt = connection.prepareStatement(sql);
			// �޸ĺ������
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSage());
			pstmt.setString(3, student.getSaddress());
			// Ҫ�޸ĵ���
			pstmt.setInt(4, sno);
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			 try {
				 if(pstmt!=null) pstmt.close();
				 if(connection!=null) connection.close();
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}
	}
	
	// ����ѧ��ɾѧ��
	public boolean deleteStudentBySno(int sno) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			String sql = "delete from student where sno = ? " ;
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			 try {
				 if(pstmt!=null) pstmt.close();
				 if(connection!=null) connection.close();
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}
	}
	
	// ��ѯȫ��ѧ��
	public List<Student> queryAllStudents() {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			
			String sql = "select * from student";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				students.add(student);
				
			}	

			return students;	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 if(rs!=null) rs.close();
				 if(pstmt!=null) pstmt.close();
				 if(connection!=null) connection.close();
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}
		return students;
		
	}
	
	
	// ��ѯ�����Ƿ����
	public boolean isExist(int sno) {// false:���˲����ڣ�true:���˴���
		return queryStudentBySno(sno)==null? false:true;
	}
	
	
	// ����ѧ�Ų�ѧ��
	public Student queryStudentBySno(int sno) {
		Student student = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			
			String sql = "select * from student where sno=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				
			}	

			return student;	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 if(rs!=null) rs.close();
				 if(pstmt!=null) pstmt.close();
				 if(connection!=null) connection.close();
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
		}
		return student;
		
	}

}