package crm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static final String url="jdbc:mysql://localhost:3306/crm?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true";
	public static final String user="root";
	public static final String password="123456";
	
	/**
	 * �������ݿ�
	 * @return ���Ӷ���
	 */
	@SuppressWarnings("finally")
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			
		} 
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (SQLException e) {			
			e.printStackTrace();
		}
		finally {
			return conn;
		}
		
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con ���Ӷ���
	 */
	public static void close(Connection con)
	{
		
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(getConnection().toString());
	}
	
	
	
	
	

}
