package crm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import crm.dao.CustomerDao;
import crm.model.Customer;
import crm.model.Region;
import crm.util.DBUtil;

/**
 * 功能：客户数据访问类
 * @author 
 * @version1.0
 *
 */
public class CustomerService {

	CustomerDao cs=new CustomerDao();
	
	/**
	 * 添加客户
	 * @param cus  要添加的客户对象
	 * @return 添加成功返回true 否则返回false
	 */
	public void insert(Customer cus)
	{
		cs.insert(cus);
	}
	
	
	
	/**
	 * 按id删除
	 * @param id
	 */
	public void del(int id) {
		cs.del(id);
	}

	
	
	/**
	 * 查询所有记录
	 * @return 所有记录集合
	 */
	public List<Customer> selectAll (int curpage,int pagesize)
	{
		return cs.selectAll(curpage, pagesize);
	}
	
	
	
	
	/**
	 * 全部查询
	 */
	public List<Customer> selectAll()
	{
		return cs.selectAll();
	}
	
	
	/**
	 * 修改信息
	 * @param args
	 */
	public void update(Customer up) 
	{
		cs.update(up);
	}
	
	

	/**
	 * 按照id查询
	 * @param id 查询的对象id
	 * @return 查询到的对象1
	 * 
	 */
	public Customer selectById (int id)
	{
		return cs.selectById(id);
	}
	
	
	
	/**
	 *	查询总记录数
	 * @return
	 */
	public int selectAllCount ( )
	  {
		return cs.selectAllCount();
	  }
	
	
	
	/**
	 * 按条件查询总记录数
	 * @return
	 */
	
	public int selectAllCount (String condition,String key )
	  {
		return cs.selectAllCount(condition, key);	 
		}
	
	/**
	 * 按条件分页查询
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Customer> selectAll (String condition,String key,int curpage,int pagesize)
	{
		
		return cs.selectAll(condition, key, curpage, pagesize);
	}
	
	public static void main(String[] args) {
		CustomerDao sc=new CustomerDao();
		
		
		
	}
	
	
}
