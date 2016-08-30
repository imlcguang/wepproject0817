<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
	<h1>客户信息维护：修改客户信息</h1>
	<hr>
	<form
		action="${pageContext.request.contextPath }/UpdateCustServlet"  method="POST">
		<font color="red">${msg }</font>
    <%-- <%=request.getContextPath()%>  --%>
    <input type="hidden" name="id" value="${cust.customerID }">
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">客户名：</td>
			    	<td class="controler"><input type="text" name="CustomerName"value="${cust.customerName }" readonly="readonly" style="background: silver"/></td>
			    </tr>
			    <tr>
			    	<td class="label">联系人姓名： </td>
			    	<td class="controler"><input type="text" name="RelationName" value="${cust.relationName }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">联系电话：</td>
			    	<td class="controler"><input type="text" name="RelationPhone" value="${cust.relationPhone }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">地址：</td>
			    	<td class="controler"><input type="text" name="Address" value="${cust.address }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">邮箱：</td>
			    	<td class="controler"><input type="text" name="Email" value="${cust.email }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">备注：</td>
			    	<td class="controler"><input type="text" name="Remark" value="${cust.remark }"></td>
			    </tr>
			   <tr>
			  
			    	<td colspan="1" align="center">
			    	<br>
			    		&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="修改"/>&nbsp;&nbsp;
			    	   &nbsp; <input type="reset" value="取消"/>&nbsp;
			    	</td>
			    </tr>
			  </table>
			</form>
		
		
</body>
</html>