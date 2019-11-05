package crm.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm.model.Customer;
import crm.model.Employee;
import crm.model.Region;
import crm.service.CustomerService;
import crm.service.EmployeeService;
import crm.util.EXCALUtil;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * CustomerService cs=new CustomerService(); List<Customer> list=cs.selectAll(1,
		 * 6); response.setContentType("text/html;charset=utf-8"); PrintWriter
		 * out=response.getWriter(); StringBuilder sb=new StringBuilder("<table>");
		 * for(Customer cc :list) { sb.append("<tr>");
		 * 
		 * sb.append("<td>");sb.append(cc.getId());sb.append("</td>");
		 * sb.append("<td>");sb.append(cc.getName());sb.append("</td>");
		 * sb.append("<td>");sb.append(cc.getRecord());sb.append("</td>");
		 * sb.append("<td>");sb.append(cc.getRegion());sb.append("</td>");
		 * 
		 * 
		 * sb.append("</tr>");
		 * 
		 * }
		 * 
		 * sb.append("</table>"); response.getWriter().println(sb.toString());
		 */

		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		
		
		
		
		
		
		
		
//		String condition=request.getParameter("chaxun");
//		String key=request.getParameter("key");
//		System.out.print(condition);
//	PrintWriter ccs=response.getWriter();
//	Gson kson=new Gson();
//	EmployeeService sc=new EmployeeService();
//
//	int curpage=Integer.parseInt( request.getParameter("page"));
//	int pagesize=Integer.parseInt(request.getParameter("limit"));
//
//	Map<String, Object> map=new HashMap();
//	List<Employee> csc=sc.selectAll(condition,key,curpage, pagesize);
//	int count =sc.selectAllCount(condition, key);
//	map.put("code",0);
//	map.put("msg", "查询完成");
//	map.put("count",count);
//	map.put("data",csc);
//	
//	
//	String wsx=kson.toJson(map);
//	
//	ccs.write(wsx);
		
		String action=request.getParameter("action");
		if(action.equals("selbycon"))
		{
			String condition=request.getParameter("chaxun");
			String key=request.getParameter("key");
			PrintWriter con=response.getWriter();
			Gson gson=new Gson();
			CustomerService sc=new CustomerService();
			int curpage=Integer.parseInt( request.getParameter("page"));
			int pagesize=Integer.parseInt(request.getParameter("limit"));
			List<Customer> csc=sc.selectAll(condition, key, curpage, pagesize);
			Map<String, Object> map=new HashMap();
			int count =sc.selectAllCount(condition, key);
			map.put("code",0);
			map.put("msg", "查询完成");
			map.put("count",count);
			map.put("data",csc);
			String wsx=gson.toJson(map);
						con.write(wsx);
		}
		else if(action.equals("sel"))
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter con=response.getWriter();
			Gson gson=new Gson();
			CustomerService sc=new CustomerService();
			int curpage=Integer.parseInt( request.getParameter("page"));
			int pagesize=Integer.parseInt(request.getParameter("limit"));
			List<Customer> csc=sc.selectAll(curpage, pagesize);
			Map<String, Object> map=new HashMap();
			int count =sc.selectAllCount();
			map.put("code",0);
			map.put("msg", "查询完成");
			map.put("count",count);
			map.put("data",csc);
			String wsx=gson.toJson(map);
			
			con.write(wsx);
		}
		
		else if(action.equals("del"))
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter con=response.getWriter();
			CustomerService sc=new CustomerService();
			int id=Integer.parseInt(request.getParameter("id"));
			sc.del(id);
			Map<String, Object> map=new HashMap();
			map.put("code",0);
			map.put("msg", "删除成功");
			map.put("count",1);
			map.put("data",null);	
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			response.getWriter().write(wsx);
		}
		else if(action.equals("upd"))
		{
			
			CustomerService rs=new CustomerService();
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String telephone=request.getParameter("telephone");
			String status=request.getParameter("status");
			String record=request.getParameter("record");
			String region=request.getParameter("region");
			int Employeeid=Integer.parseInt(request.getParameter("Employeeid"));
			Customer up=new Customer();
			up.setEmployeeid(Employeeid);
			up.setId(id);
			up.setName(name);
			up.setRecord(record);
			up.setRegion(region);
			up.setStatus(status);
			up.setTelephone(telephone);
			
			rs.update(up);
			
			Map<String, Object> map=new HashMap();
			
			map.put("code",0);
			map.put("msg", "修改成功");
			map.put("count",1);
			map.put("data",null);
			
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			
			response.getWriter().write(wsx);
			
		}
		else if(action.equals("ins"))
		{
			
		
			CustomerService rs=new CustomerService();
			
			String nameadd=request.getParameter("nameadd");
			String telephoneadd=request.getParameter("telephoneadd");
			String statusadd=request.getParameter("statusadd");
			String recordadd=request.getParameter("recordadd");
			String regionadd=request.getParameter("regionadd");
			
			int Employeeidadd=Integer.parseInt(request.getParameter("Employeeidadd"));
			Customer up=new Customer();
			up.setEmployeeid(Employeeidadd);
			up.setName(nameadd);
			up.setRecord(recordadd);
			up.setRegion(regionadd);
			up.setStatus(statusadd);
			up.setTelephone(telephoneadd);
			
			
			rs.insert(up);
			
			Map<String, Object> map=new HashMap();
			
			map.put("code",0);
			map.put("msg", "添加成功");
			map.put("count",1);
			map.put("data",null);
			
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			
			response.getWriter().write(wsx);
			
		}
		else if(action.equals("dao")) 
		{
			String[] colNames=new String[7];
			colNames[0]="ID";
			colNames[1]="姓名";
			colNames[2]="联系方式";
			colNames[3]="状态";
			colNames[4]="沟通记录";
			colNames[5]="区域";
			colNames[6]="员工编号";
			CustomerService sc=new CustomerService();
			List<Customer> list=sc.selectAll();
			List<Object[]> datalist=new ArrayList<Object[]>();
		
			for(Customer em:list)
			{
				Object[] cols=new Object[7];
				cols[0]=em.getId();
				cols[1]=em.getName();
				cols[2]=em.getTelephone();
				cols[3]=em.getRecord();
				cols[4]=em.getRegion();
				cols[5]=em.getStatus();
				cols[6]=em.getEmployeeid();
				datalist.add(cols);
			}
		
EXCALUtil excel= new EXCALUtil("客户数据",colNames,datalist);
		
		String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
	     //告诉浏览器数据格式，将头和数据传到前台
	      String headStr = "attachment; filename=\"" + fileName + "\"";
	      response.setContentType("APPLICATION/OCTET-STREAM");
	      response.setHeader("Content-Disposition", headStr);
	      OutputStream out = response.getOutputStream();
		
	      try {
			excel.export(out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
