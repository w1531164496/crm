package crm.service;

import java.util.List;

import crm.dao.EmployeeDao;
import crm.model.Employee;

public class EmployeeService {
	EmployeeDao cs=new EmployeeDao();
	
	
	
	/**
	 * ��ӿͻ���Ϣ
	 * @param ins
	 */
	public void insert(Employee ins)
	{
		cs.insert(ins);
	}
	
	
	
	/**
	 * ����idɾ���ͻ���Ϣ
	 * @param id
	 */
	public void del(int id)
	{
		cs.del(id);
	}
	
	
	
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param up
	 */
	public void update(Employee up)
	{
		cs.update(up);
	}
	
	
	
	/**
	 * ����ȫ����Ϣ
	 * @param sel
	 * @return
	 */
	public List<Employee> select()
	{
		return cs.select();
	}
	
	
	
	/**
	 * ��ҳ��ѯ
	 */
	public List<Employee> selectAll(int curpage, int pagesize)
	{
		return cs.selectAll( curpage, pagesize);
	}
	
	
	
	/**
	 * ��ѯ��¼����
	 * @return
	 */
	public int selectALLConut()
	{
		return cs.selectAllCount();
	}
	
	
	
	/**
	 * ��������ѯ
	 * @param condition
	 * @param key
	 * @return
	 */
	public int selectAllCount (String condition,String key)
	  {
	  return cs.selectAllCount(condition,key);
	  }
	
	
	
	/**
	 * ��������ҳ��ѯ�ܼ�¼��
	 * @param args
	 */

	public List<Employee> selectAll (String condition,String key,int curpage,int pagesize)
	{
		return cs.selectAll(condition, key, curpage, pagesize);
		
	}
	/**
	 * ���û��������ѯ�ܼ�¼��
	 * @return
	 */
	
	public Employee selectByName (String username,String password )
	  {
		return cs.selectByName(username, password);
	  }
	
	
	
}
