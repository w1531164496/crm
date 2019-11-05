package crm.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ExportsStatement;

import com.google.gson.Gson;

import crm.model.Employee;
import crm.model.Region;
import crm.service.EmployeeService;
import crm.service.RegionService;
import crm.util.EXCALUtil;
import crm.util.MD5Util;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		/**
		 * 分页查询
		 */
		String action=request.getParameter("action");
		if(action.equals("selbycon"))
		{
			
			String condition=request.getParameter("chaxun");
			String key=request.getParameter("key");
					PrintWriter ccs=response.getWriter();
		Gson kson=new Gson();
		EmployeeService sc=new EmployeeService();
	
		int curpage=Integer.parseInt( request.getParameter("page"));
		int pagesize=Integer.parseInt(request.getParameter("limit"));
	
		Map<String, Object> map=new HashMap();
		List<Employee> csc=sc.selectAll(condition,key,curpage, pagesize);
		int count =sc.selectAllCount(condition, key);
		map.put("code",0);
		map.put("msg", "查询完成");
		map.put("count",count);
		map.put("data",csc);
		
		
		String wsx=kson.toJson(map);
		
		ccs.write(wsx);
		System.out.print(wsx);
		}
		else if(action.equals("sel"))
		{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter ccs=response.getWriter();
		Gson kson=new Gson();
		EmployeeService sc=new EmployeeService();
		int curpage=Integer.parseInt( request.getParameter("page"));
		int pagesize=Integer.parseInt(request.getParameter("limit"));
		List<Employee> csc=sc.selectAll(curpage, pagesize);
		
		
		Map<String, Object> map=new HashMap();
	
		int count =sc.selectALLConut();
		map.put("code",0);
		map.put("msg", "查询完成");
		map.put("count",count);
		map.put("data",csc);
		
		
		String wsx=kson.toJson(map);
		
		ccs.write(wsx);
		}
		
		
		/**
		 * 按id号删除
		 */
		else if(action.equals("del"))
		{

			int id=Integer.parseInt( request.getParameter("id"));
			EmployeeService rs=new EmployeeService();
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
		
		else if(action.equals("upd"))
		{
		
			EmployeeService rs=new EmployeeService();
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String	telephone=request.getParameter("telephone");
			String	address=request.getParameter("address");
			String	nativeplace=request.getParameter("nativeplace");
			String	gender=request.getParameter("gender");
			String	password=MD5Util.stringToMD5(request.getParameter("password"));
			String	username=request.getParameter("username");
			String	nickname=request.getParameter("nickname");
			String	headportrait=request.getParameter("headportrait");
			String	remarks=request.getParameter("remarks");
			String role=request.getParameter("role");
			int	Schoolid=Integer.parseInt(request.getParameter("Schoolid"));
			
			
			Employee up=new Employee();
			up.setRole(role);
			up.setSchoolid(Schoolid);
			up.setGender(gender);
			up.setAddress(address);
			up.setHeadportrait(headportrait);
			up.setname(name);
			up.setNickname(nickname);
			up.setPassword(password);
			up.setRemarks(remarks);
			up.setId(id);
			up.settelephone(telephone);
			up.setUsername(username);
			up.setNativeplace(nativeplace);
			rs.update(up);
			
			
			Map<String, Object> map=new HashMap();
			
			map.put("code",0);
			map.put("msg", "修改成功");
			map.put("count",1);
			map.put("data",null);
			
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			
			response.getWriter().write(wsx);
			
			System.out.println(wsx);
		}
		else if(action.equals("ins"))
		{
			
			EmployeeService rs=new EmployeeService();
			String nameadd=request.getParameter("nameadd");
			String	telephoneadd=request.getParameter("telephoneadd");
			String	addressadd=request.getParameter("addressadd");
			String	nativeplaceadd=request.getParameter("nativeplaceadd");
			String	genderadd=request.getParameter("genderadd");
			String	passwordadd=MD5Util.stringToMD5(request.getParameter("passwordadd"));
					
			String	usernameadd=request.getParameter("usernameadd");
			String	nicknameadd=request.getParameter("nicknameadd");
			String	headportraitadd=request.getParameter("headportraitadd");
			String	remarksadd=request.getParameter("remarksadd");
			int	Schoolidadd=Integer.parseInt(request.getParameter("Schoolidadd"));
			String roleadd=request.getParameter("roleadd");
			
			
			
			Employee up=new Employee();
			up.setSchoolid(Schoolidadd);
			up.setGender(genderadd);
			up.setAddress(addressadd);
			up.setHeadportrait(headportraitadd);
			up.setname(nameadd);
			up.setNickname(nicknameadd);
			up.setPassword(passwordadd);
			up.setRemarks(remarksadd);
			up.settelephone(telephoneadd);
			up.setUsername(usernameadd);
			up.setRole(roleadd);
			
			up.setNativeplace(nativeplaceadd);
			rs.insert(up);
			
			
			Map<String, Object> map=new HashMap();
			
			map.put("code",0);
			map.put("msg", "添加成功");
			map.put("count",1);
			map.put("data",null);
			
			Gson kson=new Gson();
			String wsx=kson.toJson(map);
			
			response.getWriter().write(wsx);
			
			System.out.println(wsx);
		}
		
		
		
		
		/**
	     * 导出excel文件
	     */

	else if (action.equals("dao")) {	
		String[] colNames=new String[13];
		colNames[0]="ID";
		colNames[1]="姓名";
		colNames[2]="地址";
		colNames[3]="联系方式";
		colNames[4]="性别";
		colNames[5]="籍贯";
		colNames[6]="密码";
		colNames[7]="用户名";
		colNames[8]="昵称";
		colNames[9]="头像";
		colNames[10]="备注";
		colNames[11]="校区编号";
		colNames[12]="角色";
		EmployeeService sc=new EmployeeService();
		List<Employee> list=sc.select();
		List<Object[]> datalist=new ArrayList<Object[]>();
		
		for(Employee em : list)
		{
			Object[] cols=new Object[13];
			cols[0]=em.getId();
			cols[1]=em.getname();
			cols[2]=em.getAddress();
			cols[3]=em.gettelephone();
			cols[4]=em.getGender();
			cols[5]=em.getNativeplace();
			cols[6]=em.getPassword();
			cols[7]=em.getUsername();
			cols[8]=em.getNickname();
			cols[9]=em.getHeadportrait();
			cols[10]=em.getRemarks();
			cols[11]=em.getSchoolid();
			cols[12]=em.getRole();
			
			
			datalist.add(cols);
		
		}
		
		
		EXCALUtil excel= new EXCALUtil("员工数据",colNames,datalist);
		
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
