package cn.web.Servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.Util.HttpClientUtil;
import cn.Util.PropertiesUtil;

public class InitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		
		InputStream in = HttpClientUtil.imageInStream(PropertiesUtil
				.getValue("valiCode"));
		OutputStream sos = response.getOutputStream();
		
		response.setHeader("Content-Type","image/jpeg");
		
		byte[] bytes = new byte[1024];
		
		while( (in.read(bytes)) != -1 ){
			sos.write(bytes);
		}
		
		sos.flush();
		sos.close();
		in.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
