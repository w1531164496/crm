package crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.model.Employee;
import crm.model.Region;
import crm.util.DBUtil;

public class RegionDao {
	/**
	 * 添加
	 */
	public void insert(Region ins)
	{
		Connection con=DBUtil.getConnection();
		String sql="insert into Region(schoolName,schoolintroduce,schoolhead,telephone)"+"values("+"?,?,?,?)";
		try {
			PreparedStatement sc=con.prepareStatement(sql);
			sc.setString(1, ins.getSchoolName());
			sc.setString(2, ins.getSchoolintroduce());
			sc.setString(3, ins.getSchoolhead());
			sc.setString(4, ins.getTelephone());			
			sc.execute();
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除
	 */
	public void del(int id)
	{
		Connection con=DBUtil.getConnection();
		String sql="delete from Region where id=?";
		try {
			PreparedStatement sc=con.prepareStatement(sql);
			sc.setInt(1, id);
			sc.execute();
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 修改根据id
	 * 
	 */
	public void update(Region cs)
	{
		Connection con=DBUtil.getConnection();
		String sql="update region set schoolName=?,schoolintroduce=?,schoolhead=?,telephone=?  where id=?";
		try {
			PreparedStatement sc=con.prepareStatement(sql);
			sc.setString(1,cs.getSchoolName() );
			sc.setString(2, cs.getSchoolintroduce());
			sc.setString(3, cs.getSchoolhead());
			sc.setString(4, cs.getTelephone());
			sc.setInt(5, cs.getId());
			sc.execute();
			DBUtil.close(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 全部查询
	 * @return
	 */
	public List<Region> select()
	{
		List<Region> list=new ArrayList<Region>();
		Connection con=DBUtil.getConnection();
		String sql="select *from region ";
		try {
			PreparedStatement sc=con.prepareStatement(sql);
			ResultSet rs=sc.executeQuery();
			while(rs.next())
				{
				Region cus=new Region();
				cus.setId(rs.getInt("id"));
				cus.setSchoolhead(rs.getString("Schoolhead"));
				cus.setSchoolintroduce(rs.getString("Schoolintroduce"));
				cus.setSchoolName(rs.getString("SchoolName"));
				cus.setTelephone(rs.getString("Telephone"));
				list.add(cus);
				}
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  list;
	}
	
	/**
	 * 查询总记录数
	 * @return
	 */
	
	public int selectAllCount ( )
	  {
	   
	   String sql="select count(*) as c from Region";
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
	 * 按条件查询总记录数
	 * @return
	 */
	
	public int selectAllCount (String condition,String key )
	  {
	   
	   String sql="select count(*) as c from Region where "+condition+"=?";
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
	 * 按条件分页查询
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Region> selectAll (String condition,String key,int curpage,int pagesize)
	{
		List<Region> list=new ArrayList<Region>();
		String sql="select * from Region where "+condition+"=? order by id desc limit ?,?";
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
				Region cus=new Region();
				cus.setId(rs.getInt("id"));
				cus.setSchoolhead(rs.getString("schoolhead"));
				cus.setSchoolintroduce(rs.getString("schoolintroduce"));
				cus.setSchoolName(rs.getString("schoolname"));
				cus.setTelephone(rs.getString("telephone"));
				
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
	 * 分页查询
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Region> selectAll (int curpage,int pagesize)
	{
		List<Region> list=new ArrayList<Region>();
		String sql="select * from Region order by id desc limit ?,?";
		Connection con=DBUtil.getConnection();
		
		try {
//			Statement se=con.createStatement();
			PreparedStatement se=con.prepareStatement(sql);
			se.setInt(1,(curpage-1)*pagesize);
			se.setInt(2,pagesize);
			ResultSet rs=se.executeQuery();
			
			while(rs.next())
			{
				Region cus=new Region();
				cus.setId(rs.getInt("id"));
				cus.setSchoolhead(rs.getString("schoolhead"));
				cus.setSchoolintroduce(rs.getString("schoolintroduce"));
				cus.setSchoolName(rs.getString("schoolname"));
				cus.setTelephone(rs.getString("telephone"));
				
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
	
	
	
	
}
