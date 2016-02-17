package cn.web.Servlet;

import java.io.IOException;

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
			
			if( operate.equals("kebiao") ){
				
				System.out.println(new InfoService().getLesson());
				
				
			}else if(operate.equals("chengji") ){
				
				System.out.println(new InfoService().getGrade());
				
			}
			
			
			

	}

	


}
