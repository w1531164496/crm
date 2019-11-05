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
	 * 添加
	 */
	public void insert(Region ins)
	{
		as.insert(ins);
	}
	
	
	
	
	/**
	 * 删除
	 */
	public void del(int id)
	{
		as.del(id);
	}
	
	
	
	
	/**
	 * 修改
	 */
	public void update(Region cs)
	{
		as.update(cs);
	}
	
	
	
	
	/**
	 * 查询
	 */
	public List<Region> select()
	{
		 return as.select();
	}
	
	
	
	/**
	 * 分页查询
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Region> selectAll(int curpage, int pagesize)
	{
		return as.selectAll(curpage, pagesize);
	}
	
	
	
	
	/**
	 * 查询总记录个数
	 * @return
	 */
	public int selectALLConut()
	{
		return as.selectAllCount();
	}
	

	
	
	/**
	 * 按条件分页查询
	 * @param curpage
	 * @param pagesize
	 * @return
	 */
	public List<Region> selectAll (String condition,String key,int curpage,int pagesize)
	{
		
		return as.selectAll(condition, key, curpage, pagesize);
	}
	
	
	
	

	/**
	 * 按条件查询总记录数
	 * @return
	 */
	
	public int selectAllCount (String condition,String key )
	  {
		return as.selectAllCount(condition, key);	 
		}
	   
	
	
	
	
	
	
	
	

}
