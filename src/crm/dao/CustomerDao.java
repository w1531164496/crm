package crm.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crm.model.Customer;
import crm.model.Region;
import crm.util.DBUtil;
@SuppressWarnings("unused")
public class CustomerDao {

	/**
	 * ��ӿͻ�
	 * @param cus  Ҫ��ӵĿͻ�����
	 * @return ��ӳɹ�����true ���򷵻�false
	 */
	public void insert(Customer cus)
	{
	
		Connection con=DBUtil.getConnection();
		String sql="insert into customer(name,telephone,status,record,region,Employeeid)"+" values(?,?,?,?,?,?) ";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cus.getName());
			ps.setString(2, cus.getTelephone());
			ps.setString(3, cus.getStatus());
			ps.setString(4, cus.getRecord());
			ps.setString(5, cus.getRegion());
			ps.setInt(6,cus.getEmployeeid());
			 ps.execute();
			DBUtil.close(con);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	/**
	 * ɾ�����ݿ�����
	 * @param id
	 */
	public void del(int id) 
	{
		
		String sql="delete from customer where id=?";
		Connection con=DBUtil.getConnection();
		
		try {
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps = con.prepareStatement(sql);
				ps.setInt(1,id);
				
				ps.execute();
				DBUtil.close(con);
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * �޸�
	 * @param cs ����id�����޸�
	 */
	public void update(Customer up) 
	{
		String sql="update customer set name=?,record=?,region=?,status=?,Employeeid=?,telephone=?  where id=? ";
		Connection con=DBUtil.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, up.getName());
			ps.setString(2, up.getRecord());
			ps.setString(3, up.getRegion());
			ps.setString(4, up.getStatus());
			ps.setInt(5, up.getEmployeeid());
			ps.setString(6, up.getTelephone());
			ps.setInt(7, up.getId());
			ps.execute();
			DBUtil.close(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		}	
	

	/**
	 * ����id��ѯ
	 * @param id ��ѯ�Ķ���id
	 * @return ��ѯ���Ķ���1
	 * 
	 */
	public Customer selectById (int id)
	{
		
		String sql="select* from customer where id=?";
		Connection con=DBUtil.getConnection();
		Customer cus=new Customer();
		
		try {
			PreparedStatement se=con.prepareStatement(sql);
			se.setInt(1,id);
			ResultSet rs=se.executeQuery();			
			rs.next();			
			cus.setName(rs.getString("name"));
			cus.setRecord(rs.getString("record"));
			cus.setRegion(rs.getString("region"));
			cus.setEmployeeid(rs.getInt("Employeeid"));
			cus.setStatus(rs.getString("status"));
			cus.setTelephone(rs.getString("telephone"));
			if(se!=null)
			{se.close();}
			if(rs!=null)
			{rs.close();}
			DBUtil.close(con);
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return cus;		
	}
	
	/**
	 * ����������
	 */
	public Customer selectByname(String name)
	{
		Connection con=DBUtil.getConnection();
		String sql="select *from cusotmer where name=?";
		Customer cus=new Customer();
		try {
			PreparedStatement sc=con.prepareStatement(sql);
			sc.setString(1, name);
			ResultSet rs=sc.executeQuery();
			cus.setName(rs.getString("name"));
			cus.setRecord(rs.getString("record"));
			cus.setRegion(rs.getString("Region"));
			cus.setStatus(rs.getString("status"));
			cus.setTelephone(rs.getString("telephone"));
			cus.setEmployeeid(rs.getInt("Employeeid"));
			if(rs!=null)
			{
				rs.close();
			}
			if(sc!=null)
			{
				sc.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cus;
	}
	
	
	
	/**
	 * ��ѯ�ܸ���
	 * @return
	 */
	public int selectAllCount ( )
	  {
	   
	   String sql="select count(*) as c from Customer";
	  Connection con=DBUtil.getConnection();
	  PreparedStatement stmt;
	  int count=0;
	  try {
	   stmt = con.prepareStatement(sql);   
	   ResultSet rs = stmt.executeQuery();
	   if(rs.next())
	   { 
	    count= rs.getInt("c");
	   }
	    
	   if(stmt!=null)
	    stmt.close();
	    if(rs!=null)
	    rs.close();
	    if(con!=null)
	    DBUtil.close(con);   
	    
	    
	  } 
	  
	  catch (SQLException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  return count; 
	 
	 
	  }
	
	
	
	/**
	 * ��ѯ���м�¼��ҳ��ѯ
	 * @return ���м�¼����
	 */
	public List<Customer> selectAll (int curpage,int pagesize)
	{
		List<Customer> list=new ArrayList<Customer>();
		String sql="select * from Customer order by id desc limit ?,?";
		Connection con=DBUtil.getConnection();
		
		try {
//			Statement se=con.createStatement();
			PreparedStatement se=con.prepareStatement(sql);
			se.setInt(1,(curpage-1)*pagesize);
			se.setInt(2,pagesize);
			ResultSet rs=se.executeQuery();
			
			while(rs.next())
			{
				Customer cus=new Customer();
				
				cus.setId(rs.getInt("id"));
				cus.setName(rs.getString("name"));
				cus.setRecord(rs.getString("record"));
				cus.setRegion(rs.getString("region"));
				cus.setStatus(rs.getString("status"));
				cus.setTelephone(rs.getString("telephone"));
				cus.setEmployeeid(rs.getInt("Employeeid"));
				list.add(cus);
				
				
			}
			if(rs!=null) 
			{
				rs.close();
			}
			if(se!=null) {se.close();}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	/**
	 * ��������ѯ�ܼ�¼��
	 * @return
	 */
	
	public int selectAllCount (String condition,String key )
	  {
	   
	   String sql="select count(*) as c from Customer where "+condition+"=?";
	  Connection con=DBUtil.getConnection();
	  PreparedStatement stmt;
	  int count=0;
	  try {
	   stmt = con.prepareStatement(sql);   
	   stmt.setString(1, key);
	   ResultSet rs = stmt.executeQuery();   
	   if(rs.next())
	   { 
	    count= rs.getInt("c");
	   }
	    
	   if(stmt!=null)
	    stmt.close();
	    if(rs!=null)
	    rs.close();
	    if(con!=null)
	    DBUtil.close(con);   
	  } 
	  
	  catch (SQLException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  return count; 
	 
	 
	  }
		
	
	
	/**
	 * ��������ҳ��ѯ
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Customer> selectAll (String condition,String key,int curpage,int pagesize)
	{
		List<Customer> list=new ArrayList<Customer>();
		String sql="select * from Customer where "+condition+"=? order by id desc limit ?,?";
		Connection con=DBUtil.getConnection();
		
		try {
//			Statement se=con.createStatement();
			PreparedStatement se=con.prepareStatement(sql);
			se.setString(1,key);
			
			se.setInt(2,(curpage-1)*pagesize);
			se.setInt(3,pagesize);
			ResultSet rs=se.executeQuery();
			
			while(rs.next())
			{
				Customer cus=new Customer();
				cus.setId(rs.getInt("id"));
				cus.setName(rs.getString("name"));
				cus.setRecord(rs.getString("record"));
				cus.setRegion(rs.getString("region"));
				cus.setStatus(rs.getString("status"));
				cus.setTelephone(rs.getString("telephone"));
				cus.setEmployeeid(rs.getInt("Employeeid"));
				list.add(cus);
				
				
			}
			if(rs!=null) 
			{
				rs.close();
			}
			if(se!=null) {se.close();}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	/**
	 * ȫ����ѯ
	 */
	public List<Customer> selectAll()
	{
		List<Customer> list=new ArrayList<Customer>();
		Connection con=DBUtil.getConnection();
		String sql="select * from Customer";
		try {
			PreparedStatement see=con.prepareStatement(sql);
			ResultSet rs=see.executeQuery();
			while(rs.next())
			{
				Customer cus=new Customer();
				cus.setId(rs.getInt("id"));
				cus.setName(rs.getString("name"));
				cus.setRecord(rs.getString("record"));
				cus.setRegion(rs.getString("region"));
				cus.setStatus(rs.getString("status"));
				cus.setTelephone(rs.getString("telephone"));
				cus.setEmployeeid(rs.getInt("Employeeid"));
				list.add(cus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
		
	

	
	

}
