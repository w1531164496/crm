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
 * ���ܣ��ͻ����ݷ�����
 * @author 
 * @version1.0
 *
 */
public class CustomerService {

	CustomerDao cs=new CustomerDao();
	
	/**
	 * ��ӿͻ�
	 * @param cus  Ҫ��ӵĿͻ�����
	 * @return ��ӳɹ�����true ���򷵻�false
	 */
	public void insert(Customer cus)
	{
		cs.insert(cus);
	}
	
	
	
	/**
	 * ��idɾ��
	 * @param id
	 */
	public void del(int id) {
		cs.del(id);
	}

	
	
	/**
	 * ��ѯ���м�¼
	 * @return ���м�¼����
	 */
	public List<Customer> selectAll (int curpage,int pagesize)
	{
		return cs.selectAll(curpage, pagesize);
	}
	
	
	
	
	/**
	 * ȫ����ѯ
	 */
	public List<Customer> selectAll()
	{
		return cs.selectAll();
	}
	
	
	/**
	 * �޸���Ϣ
	 * @param args
	 */
	public void update(Customer up) 
	{
		cs.update(up);
	}
	
	

	/**
	 * ����id��ѯ
	 * @param id ��ѯ�Ķ���id
	 * @return ��ѯ���Ķ���1
	 * 
	 */
	public Customer selectById (int id)
	{
		return cs.selectById(id);
	}
	
	
	
	/**
	 *	��ѯ�ܼ�¼��
	 * @return
	 */
	public int selectAllCount ( )
	  {
		return cs.selectAllCount();
	  }
	
	
	
	/**
	 * ��������ѯ�ܼ�¼��
	 * @return
	 */
	
	public int selectAllCount (String condition,String key )
	  {
		return cs.selectAllCount(condition, key);	 
		}
	
	/**
	 * ��������ҳ��ѯ
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
