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
<h1>客户信息维护</h1><hr>
 <h2>客户注册</h2>
  <font color="red">${msg }</font>
   <form name="CusForm" action="${pageContext.request.contextPath}/CusServlet" method="post" >
    <%-- <%=request.getContextPath()%>  --%>
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">客户名：</td>
			    	<td class="controler"><input type="text" name="CustomerName"value="${param.CustomerName }"/></td>
			    </tr>
			    <tr>
			    	<td class="label">联系人姓名： </td>
			    	<td class="controler"><input type="text" name="RelationName" value="${param.RelationName }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">联系电话：</td>
			    	<td class="controler"><input type="text" name="RelationPhone" value="${param.RelationPhone }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">地址：</td>
			    	<td class="controler"><input type="text" name="Address" value="${param.Address }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">邮箱：</td>
			    	<td class="controler"><input type="text" name="Email" value="${param.Email }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">备注：</td>
			    	<td class="controler"><input type="text" name="Remark" value="${param.Remark }"></td>
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
</body>
</html>