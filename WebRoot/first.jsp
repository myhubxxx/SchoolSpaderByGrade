<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <center>
    	<br/><br/><br/>
    	<br/><br/><br/>
    	<strong style=color:red>${requestScope.message }</strong>
    <form method="post" action="ControlServlet" >
    	学号 : <input type="text" name="usernumber" value="201305020346" />
    	<br/><br/>
    	密码 : <input type="password" name="password" value="ZENYAN" />
    	<br/><br/>
    	指定查询选项  : <select name="operate">
    				<option value="kebiao">课表查询</option>
    				<option value="chengji">成绩查询</option>
    				<option value="yearchengji">学期成绩</option>
    			</select>
    			
		<br/><br/>
    	验证码  : <input type="text" name="validateCode" size="6"/>
    	
    	<img id="validata" src="InitServlet" onclick="this.src='InitServlet?'+Math.random()"/>
 	
    	<br/><br/>
    	<br/>
    	
    	<input type="submit" value="登陆" /> 
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="清除"/>
 <!--    
<script language=javascript   type=text/javascript>   
 	function   getCode()
     {   

     document.getElementById('validata').src='InitServlet?temp=Math.random()';   
          
  }   
  </script>	
  
   -->
   
    </form>
    	
    </center>
  </body> 
</html>
