<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
    
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	 .label{
		  width: 20%	
	 }
	 .controler{
		  width: 80%	
	 }
   </style>  
   <script type="text/javascript" src="js/Calendar3.js"></script>
  </head>
  
  <body>
    <h1>用户信息管理</h1>
    <h2>用户注册</h2>
    <hr>
    <form name="regForm" action="<%=request.getContextPath()%>/UserServlet" method="post" >
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">登录名：</td>
			    	<td class="controler"><input type="text" name="LoginName" /></td>
			    </tr>
			    <tr>
			    	<td class="label">密码： </td>
			    	<td class="controler"><input type="password" name="Password" ></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">确认密码：</td>
			    	<td class="controler"><input type="password" name="confirmpass" ></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">用户名：</td>
			    	<td class="controler"><input type="text" name="UserName" ></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">性别：</td>
			    	<td class="controler">
			    	<input type="radio" name="UserSex" checked="checked" value="Male">Male
			    	<input type="radio" name="UserSex" value="Female">Female</td>
			    	
			    </tr>
			   
			   <!--  <tr>
			    	<td class="label">出生日期：</td>
			    	<td class="controler">
			    	  <input name="birthday" type="text" id="control_date" size="10"
                      maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
			    	</td>
			    </tr> -->
			 
		
			    <tr>
			    	<td class="label">权限：</td>
			    	<td class="controler">
			    	<input type="checkbox" name="FunctionPopedom" value="1" > 借机登记 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="2" > 样机归还 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="3" >客户信息维护 &nbsp;<br/>
			    	  <input type="checkbox" name="FunctionPopedom" value="4" > 样机信息维护 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="5" > 借机明细查询 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="6" > 借机统计 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="7" > 用户信息管理 &nbsp;
			    	</td>
			    </tr>
			   
			    
			    <tr>
			    	<td colspan="2" align="center">
			    		<input type="submit" value="注册"/>&nbsp;&nbsp;
			    	    <input type="reset" value="取消"/>&nbsp;&nbsp;
			    	</td>
			    </tr>
			  </table>
			</form>
			
			
  </body>
</html>