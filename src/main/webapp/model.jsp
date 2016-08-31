<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <style type="text/css">
	 .label{
		  width: 20%	
	 }
	 .controler{
		  width: 80%	
	 }
   </style>  
</head>
<body>
<h1>样机信息维护</h1><hr>
 <h2>样机注册</h2>
  <font color="red">${msg }</font>
   <form name="ModelForm" action="${pageContext.request.contextPath}/ModelServlet" method="post" >
    <%-- <%=request.getContextPath()%>  --%>
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">样机名称：</td>
			    	<td class="controler"><input type="text" name="ModelName"value="${param.ModelName }"/></td>
			    </tr>
			    <tr>
			    	<td class="label">样机版本： </td>
			    	<td class="controler"><input type="text" name="ModelVersion" value="${param.ModelVersion }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">样机说明：</td>
			    	<td class="controler"><input type="text" name="ModelDesc" value="${param.ModelDesc }"></td>
			    </tr>
			   <tr>
			    	<td colspan="1" align="center">
			    	<br>
			    		&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="注册"/>&nbsp;&nbsp;
			    	   &nbsp; <input type="reset" value="取消"/>&nbsp;
			    	</td>
			    </tr>
			  </table>
			</form>
			<a href=index.jsp>返回主页</a>
</body>
</html>