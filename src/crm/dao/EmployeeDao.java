package crm.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.model.Customer;
import crm.model.Employee;
import crm.model.Region;
import crm.util.DBUtil;
public class EmployeeDao {
	
	
	
//	
//	  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
//	  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '无名氏',
//	  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '18888888888',
//	  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未入学',
//	  `record` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未沟通',
//	  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '陕西',
//	  `schoolid` int(11) NOT NULL DEFAULT 0,
//	  PRIMARY KEY (`id`) USING BTREE
//	) ENGINE = InnoDB AUTO_INCREMENT = 1
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 添加客户
	 */
	public void insert(Employee ins)
	{
		Connection con=DBUtil.getConnection();
		
		String sql="insert into employee(name,telephone,address,nativeplace,gender,password,username,nickname,headportrait,remarks,Schoolid,role)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement inse=con.prepareStatement(sql);
			inse.setString(1,ins.getname());
			inse.setString(2, ins.gettelephone());
			inse.setString(3, ins.getAddress());
			inse.setString(4, ins.getNativeplace());
			inse.setString(5, ins.getGender());
			inse.setString(6, ins.getPassword());
			inse.setString(7, ins.getUsername());
			inse.setString(8, ins.getNickname());
			inse.setString(9, ins.getHeadportrait());
			inse.setString(10, ins.getRemarks());
			inse.setInt(11, ins.getSchoolid()); 
			inse.setString(12, ins.getRole());
			inse.execute();
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * 删除
	 * @param id 输入id删除内容
	 */
	public void del(int id)
	{
		Connection con=DBUtil.getConnection();
		String sql="delete from employee where id=?";
		try {
			PreparedStatement de=con.prepareStatement(sql);
			de.setInt(1,id );
			de.execute();
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 修改信息
	 */
	public void update(Employee up)
	{
		Connection con=DBUtil.getConnection();
		String sql="update employee set name=?,telephone=?,address=?,nativeplace=?,gender=?,password=?,username=?,nickname=?,headportrait=?,remarks=?,Schoolid=?,role=? where id=?";
		try {
			PreparedStatement ss=con.prepareStatement(sql);
			ss.setString(1, up.getname());
			ss.setString(2, up.gettelephone());
			ss.setString(3, up.getAddress());
			ss.setString(4, up.getNativeplace());
			ss.setString(5, up.getGender());
			ss.setString(6, up.getPassword());
			ss.setString(7, up.getUsername());
			ss.setString(8, up.getNickname());
			ss.setString(9, up.getHeadportrait());
			ss.setString(10, up.getRemarks());
			ss.setInt(11, up.getSchoolid());
			ss.setString(12, up.getRole());
			ss.setInt(13, up.getId());
			
			ss.execute();
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 全部查询
	 */
	public List<Employee> select()
	{
		List<Employee> list=new ArrayList<Employee>();
		Connection con=DBUtil.getConnection();
		String sql="select * from employee ";
		
		try {
			PreparedStatement see=con.prepareStatement(sql);
			
			ResultSet rs=see.executeQuery();
			while(rs.next())
			{	
				Employee cus=new Employee();
				cus.setId(rs.getInt("id"));
			cus.setname(rs.getString("name"));
			cus.setAddress(rs.getString("Address"));
			cus.setSchoolid(rs.getInt("Schoolid"));
			cus.setGender(rs.getString("gender"));
			cus.setHeadportrait(rs.getString("headportrait"));
			cus.setNativeplace(rs.getString("nativeplace"));
			cus.setNickname(rs.getString("nickname"));
			cus.setPassword(rs.getString("password"));
			cus.setRemarks(rs.getString("remarks"));
			cus.settelephone(rs.getString("telephone"));
			cus.setUsername(rs.getString("username"));
			cus.setRole(rs.getString("role"));
			list.add(cus);
			}
			DBUtil.close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	/**
	 * 查询总记录数
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public int selectAllCount ( )
	  {
	   
	   String sql="select count(*) as c from Employee";
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
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public int selectAllCount (String condition,String key)
	  {
	   
	   String sql="select count(*) as c from Employee where "+condition+"=?";
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
	 * @param condition
	 * @param key
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Employee> selectAll (String condition,String key,int curpage,int pagesize)
	{
		List<Employee> list=new ArrayList<Employee>();
		String sql="select * from Employee where "+condition+"=? order by id desc limit ?,?";
		Connection con=DBUtil.getConnection();
		
		try {
//			Statement se=con.createStatement();
			PreparedStatement se=con.prepareStatement(sql);
			se.setString(1, key);
			se.setInt(2,(curpage-1)*pagesize);
			se.setInt(3,pagesize);
			ResultSet rs=se.executeQuery();
			
			while(rs.next())
			{
				Employee cus=new Employee();
				cus.setId(rs.getInt("id"));
				cus.setname(rs.getString("name"));
				cus.setNativeplace(rs.getString("nativeplace"));
				cus.setAddress(rs.getString("address"));
				cus.setGender(rs.getString("gender"));
				cus.setHeadportrait(rs.getString("headportrait"));
				cus.setNickname(rs.getString("nickname"));
				cus.setPassword(rs.getString("password"));
				cus.setRemarks(rs.getString("remarks"));
				cus.setSchoolid(rs.getInt("Schoolid"));
				cus.settelephone(rs.getString("telephone"));
				cus.setUsername(rs.getString("username"));
				cus.setRole(rs.getString("role"));
				
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
	 * @param condition
	 * @param key
	 * @return
	 */
	public List<Employee> selectAll (int curpage,int pagesize)
	{
		List<Employee> list=new ArrayList<Employee>();
		String sql="select * from Employee order by id desc limit ?,?";
		Connection con=DBUtil.getConnection();
		
		try {
//			Statement se=con.createStatement();
			PreparedStatement se=con.prepareStatement(sql);
			se.setInt(1,(curpage-1)*pagesize);
			se.setInt(2,pagesize);
			ResultSet rs=se.executeQuery();
			
			while(rs.next())
			{
				Employee cus=new Employee();
			cus.setId(rs.getInt("id"));
			cus.setname(rs.getString("name"));
			cus.setNativeplace(rs.getString("nativeplace"));
			cus.setAddress(rs.getString("address"));
			cus.setGender(rs.getString("gender"));
			cus.setHeadportrait(rs.getString("headportrait"));
			cus.setNickname(rs.getString("nickname"));
			cus.setPassword(rs.getString("password"));
			cus.setRemarks(rs.getString("remarks"));
			cus.setSchoolid(rs.getInt("Schoolid"));
			cus.settelephone(rs.getString("telephone"));
			cus.setUsername(rs.getString("username"));
			cus.setRole(rs.getString("role"));
			
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
	 * 按用户名密码查询总记录数
	 * @return
	 */
	
	public Employee selectByName (String username,String password )
	  {
	  
	   String sql="select *  from Employee where username=? and password=?";
	  Connection con=DBUtil.getConnection();
	  PreparedStatement stmt;
	  Employee cus=new Employee();
	  int count=0;
	  try {
	   stmt = con.prepareStatement(sql);   
	   stmt.setString(1,username);
	   stmt.setString(2, password);
	   ResultSet rs = stmt.executeQuery();   
	   if(rs.next())
	   { 
		  
			cus.setId(rs.getInt("id"));
			cus.setname(rs.getString("name"));
			cus.setNativeplace(rs.getString("nativeplace"));
			cus.setAddress(rs.getString("address"));
			cus.setGender(rs.getString("gender"));
			cus.setHeadportrait(rs.getString("headportrait"));
			cus.setNickname(rs.getString("nickname"));
			cus.setPassword(rs.getString("password"));
			cus.setRemarks(rs.getString("remarks"));
			cus.setSchoolid(rs.getInt("Schoolid"));
			cus.settelephone(rs.getString("telephone"));
			cus.setUsername(rs.getString("username"));
			cus.setRole(rs.getString("role"));
			
			
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
	  return cus; 
	 
	 
	  }
	
	
	
	
	
	

	
	
}




















