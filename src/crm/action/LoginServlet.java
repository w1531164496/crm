package crm.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import crm.model.Employee;
import crm.service.EmployeeService;
import crm.util.MD5Util;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Map<String, Object> map=new HashMap();
		HttpSession session=request.getSession();
		 if(action.equals("login"))
		{
				
				
			String codeImg=request.getParameter("code").toLowerCase();
			String codeImga=session.getAttribute("checkcode").toString().toLowerCase();	
			String username=request.getParameter("username");
			String password=MD5Util.stringToMD5(request.getParameter("password"));
			EmployeeService sc=new EmployeeService();		
			Employee em=sc.selectByName(username, password);
		
			if(!codeImg.equals("codeImga"))
			{
				map.put("code",-1);
				map.put("msg", "验证码错误");
			}
			if(em.getUsername()==null)
			{
				map.put("code",-1);
				map.put("msg", "用户名或密码错误");
			}
			else{
				map.put("code",0);	
			
				session.setAttribute("curuser", em);
			}	
			
			map.put("count",0);
			map.put("data",null);
		}
		else
		{
			map.put("code",0);
			
			session.setAttribute("curuser", null);
		}
		
		
		Gson kson=new Gson();
		String wsx=kson.toJson(map);
		response.getWriter().write(wsx);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
