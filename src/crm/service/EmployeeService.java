package crm.service;

import java.util.List;

import crm.dao.EmployeeDao;
import crm.model.Employee;

public class EmployeeService {
	EmployeeDao cs=new EmployeeDao();
	
	
	
	/**
	 * 添加客户信息
	 * @param ins
	 */
	public void insert(Employee ins)
	{
		cs.insert(ins);
	}
	
	
	
	/**
	 * 根据id删除客户信息
	 * @param id
	 */
	public void del(int id)
	{
		cs.del(id);
	}
	
	
	
	/**
	 * 修改客户信息
	 * @param up
	 */
	public void update(Employee up)
	{
		cs.update(up);
	}
	
	
	
	/**
	 * 查找全部信息
	 * @param sel
	 * @return
	 */
	public List<Employee> select()
	{
		return cs.select();
	}
	
	
	
	/**
	 * 分页查询
	 */
	public List<Employee> selectAll(int curpage, int pagesize)
	{
		return cs.selectAll( curpage, pagesize);
	}
	
	
	
	/**
	 * 查询记录总数
	 * @return
	 */
	public int selectALLConut()
	{
		return cs.selectAllCount();
	}
	
	
	
	/**
	 * 按条件查询
	 * @param condition
	 * @param key
	 * @return
	 */
	public int selectAllCount (String condition,String key)
	  {
	  return cs.selectAllCount(condition,key);
	  }
	
	
	
	/**
	 * 按条件分页查询总记录数
	 * @param args
	 */

	public List<Employee> selectAll (String condition,String key,int curpage,int pagesize)
	{
		return cs.selectAll(condition, key, curpage, pagesize);
		
	}
	/**
	 * 按用户名密码查询总记录数
	 * @return
	 */
	
	public Employee selectByName (String username,String password )
	  {
		return cs.selectByName(username, password);
	  }
	
	
	
}
