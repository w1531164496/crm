package crm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import crm.model.Employee;
import crm.model.Region;
import crm.service.EmployeeService;
import crm.service.RegionService;

/**
 * Servlet implementation class fenyeRegionServlet
 */
@WebServlet("/RegionServlet")
public class RegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		
		String action=request.getParameter("action");
	
		
		
		
		/**
		 * 删除
		 */
		if(action.equals("del"))
		{
			int id=Integer.parseInt( request.getParameter("id"));
			RegionService rs=new RegionService();
			rs.del(id);
			Map<String, Object> map=new HashMap();
			
			map.put("code",0);
			map.put("msg", "删除成功");
			map.put("count",1);
			map.put("data",null);
			
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			
			response.getWriter().write(wsx);
			
		}
		
		
		
		/**
		 * 修改
		 */
		else if(action.equals("upd"))
		{
					
			RegionService rs=new RegionService();
			int id=Integer.parseInt(request.getParameter("id"));
			//如果页面编码格式是：ISO8859-1的格式，需要如下转化
			//String schoolName=new String(request.getParameter("schoolname").getBytes("ISO8859-1"),"utf-8");
			String schoolname=request.getParameter("schoolname");
			String schoolintroduce=request.getParameter("schoolintroduce");
			String schoolhead=request.getParameter("schoolhead");
			String telephone=request.getParameter("telephone");
			
			Region cs=new Region();
			cs.setId(id);
			cs.setSchoolhead(schoolhead);
			cs.setSchoolintroduce(schoolintroduce);
			cs.setSchoolName(schoolname);
			cs.setTelephone(telephone);
			rs.update(cs);
			
			Map<String, Object> map=new HashMap();
			
			map.put("code",0);
			map.put("msg", "修改成功");
			map.put("count",1);
			map.put("data",null);
			
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			
			response.getWriter().write(wsx);
			
		}
		
		
		
		
		/**
		 * 添加
		 */
		else if(action.equals("ins"))
		{
					
			RegionService rs=new RegionService();
			
			//如果页面编码格式是：ISO8859-1的格式，需要如下转化
			//String schoolName=new String(request.getParameter("schoolname").getBytes("ISO8859-1"),"utf-8");
			String schoolnameadd=request.getParameter("schoolnameadd");
			String schoolintroduceadd=request.getParameter("schoolintroduceadd");
			String schoolheadadd=request.getParameter("schoolheadadd");
			String telephoneadd=request.getParameter("telephoneadd");
			Region cs=new Region();	
			cs.setSchoolhead(schoolheadadd);
			cs.setSchoolintroduce(schoolintroduceadd);
			cs.setSchoolName(schoolnameadd);
			cs.setTelephone(telephoneadd);
			rs.insert(cs);
			Map<String, Object> map=new HashMap();
			map.put("code",0);
			map.put("msg", "添加成功");
			map.put("count",1);
			map.put("data",null);
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			response.getWriter().write(wsx);
		}
		
		
		
		
		/**
		 * 按条件查询
		 */
		else if(action.equals("selbycon"))
		{
			
			String condition=request.getParameter("condition");			
			String key=request.getParameter("key");
			
			PrintWriter ccs=response.getWriter();
			Gson kson=new Gson();
			RegionService sc=new RegionService();
		
			int curpage=Integer.parseInt( request.getParameter("page"));
			int pagesize=Integer.parseInt(request.getParameter("limit"));
			List<Region> csc=sc.selectAll(condition,key,curpage, pagesize);
			Map<String, Object> map=new HashMap();
		
			int count  =sc.selectAllCount(condition,key);
			map.put("code",0);
			map.put("msg", "查询完成");
			map.put("count",count);
			map.put("data",csc);
			
			
			String wsx=kson.toJson(map);			
			ccs.write(wsx);
		
		}
		
		
		
		
		/**
		 * 查询
		 */
		else if(action.equals("sel"))
		{

			response.setContentType("text/html;charset=utf-8");
			PrintWriter ccs=response.getWriter();
			Gson kson=new Gson();
			RegionService sc=new RegionService();
		
			int curpage=Integer.parseInt( request.getParameter("page"));
			int pagesize=Integer.parseInt(request.getParameter("limit"));
			List<Region> csc=sc.selectAll(curpage, pagesize);
			Map<String, Object> map=new HashMap();
		
			int count =sc.selectALLConut();
			map.put("code",0);
			map.put("msg", "查询完成");
			map.put("count",count);
			map.put("data",csc);
			
			
			String wsx=kson.toJson(map);
			
			ccs.write(wsx);
			System.out.println(wsx);
			
		}
		
		
		
		
		
	
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
