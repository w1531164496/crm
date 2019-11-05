package crm.ex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class aaaaaaaaa {
	public static final String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	public static final String user="root";
	public static final String password="123456";

	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,password);
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery("select ename from emp ");
//		while(rs.next()) {
//			System.out.println(rs.getString("ename"));
//		}
		/*
		 * String sql = "insert into emp(ENAME,JOB)"+"values("+"?,?)"; PreparedStatement
		 * ptmt = conn.prepareStatement(sql); ptmt.setString(1,"asdasd");
		 * ptmt.setString(2,"asdasdfff"); ptmt.execute();
		 */
		
/*		String sql1="delet from emp where id=2";
		PreparedStatement ptmt1 = conn.prepareStatement(sql1);*/
		
		/*
		 * String sql2 = "update emp set ename=? where id=2"; PreparedStatement ptmt =
		 * conn.prepareStatement(sql2); ptmt.setString(1,"sadsadasd");
		 */
//		String sql="insert into dept(DEPTNO,DNAME,LOC)values("+"?,?,?)";
//		PreparedStatement ptmt=conn.prepareStatement(sql);ptmt.setString(1,"10");
//		ptmt.setString(2, "asdasdasd");
//		ptmt.setString(3, "asdsafxzcqwe");
//		
		/*String sql="delet from emp where ename=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1,"SMITH");*/
		
		/*
		 * String sql="update emp set ename=? where id=?"; PreparedStatement
		 * ptmt=conn.prepareStatement(sql); ptmt.setString(1,"10"); ptmt.setInt(2, 4);
		 */
	
		PreparedStatement ptmt1 = conn.prepareStatement("delete from emp where ename=?");
		ptmt1.setString(1,"SMITH" );
		ptmt1.execute();
		conn.close();
		
		
		
	}

}
