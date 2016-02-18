package cn.web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Service.AuthService;
import cn.Service.InfoService;

public class ControlServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf8");
			
			String validate = request.getParameter("validateCode");
			String usernumber = request.getParameter("usernumber");
			String password = request.getParameter("password");
			String operate = request.getParameter("operate");
			
			AuthService as = new AuthService();
			as.Auth(usernumber, password, validate);
			
			// the result
			StringBuilder sb = null;
			
			if( operate.equals("kebiao") ){
				
				sb = new InfoService().getLesson();
				
				
			}else if(operate.equals("chengji") ){
				
				sb = new InfoService().getGrade();
				
			}else if (operate.equals("yearchengji")){
				
				sb = new InfoService().getTeamGrade();
				
			}
			
			// 
			int index = sb.indexOf("<body");
			sb.replace(0, index, " ");
			
			request.setAttribute("info", sb);
			request.getRequestDispatcher("show.jsp").forward(request, response);
			return;
			// show the result to page
			//printOut(response, sb);
			
			
			

	}

	public void printOut(HttpServletResponse resp, StringBuilder sb) throws IOException{
		PrintWriter out = resp.getWriter();
		
		out.print(sb.toString());
		
	}
	


}
