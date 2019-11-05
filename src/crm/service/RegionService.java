package crm.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import crm.dao.RegionDao;
import crm.model.Employee;
import crm.model.Region;

public class RegionService {
	RegionDao as=new RegionDao();
	/**
	 * ���
	 */
	public void insert(Region ins)
	{
		as.insert(ins);
	}
	
	
	
	
	/**
	 * ɾ��
	 */
	public void del(int id)
	{
		as.del(id);
	}
	
	
	
	
	/**
	 * �޸�
	 */
	public void update(Region cs)
	{
		as.update(cs);
	}
	
	
	
	
	/**
	 * ��ѯ
	 */
	public List<Region> select()
	{
		 return as.select();
	}
	
	
	
	/**
	 * ��ҳ��ѯ
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Region> selectAll(int curpage, int pagesize)
	{
		return as.selectAll(curpage, pagesize);
	}
	
	
	
	
	/**
	 * ��ѯ�ܼ�¼����
	 * @return
	 */
	public int selectALLConut()
	{
		return as.selectAllCount();
	}
	

	
	
	/**
	 * ��������ҳ��ѯ
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Region> selectAll (String condition,String key,int curpage,int pagesize)
	{
		
		return as.selectAll(condition, key, curpage, pagesize);
	}
	
	
	
	

	/**
	 * ��������ѯ�ܼ�¼��
	 * @return
	 */
	
	public int selectAllCount (String condition,String key )
	  {
		return as.selectAllCount(condition, key);	 
		}
	   
	
	
	
	
	
	
	
	

}
