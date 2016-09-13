<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>归还登记</title>
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
<h1>借还信息</h1><hr>
 <h2>借机登记</h2>
  <font color="red">${msg }</font>
   <form name="BorForm" action="${pageContext.request.contextPath}/ReturnServlet" method="post" >
    <%-- <%=request.getContextPath()%>  --%>
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			     <tr>
			    	<td class="label"></td>
			    	<td class="controler"><input type="hidden" id="id"  name="id" value="${param.id }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">借机操作员ID：</td>
			    	<td class="controler"><input type="text" id="ReturnOperator" name="ReturnOperator" value="${param.ReturnOperator }"></td>
			    </tr>
			    	<td colspan="1" align="center">
			    	<br>
			    		&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="归还"/>&nbsp;&nbsp;
			    	   &nbsp; <input type="reset" value="取消"/>&nbsp;
			    	</td>
			    </tr>
			  </table>
			</form>
			<a href=ListBorrowServlet>返回借机明细列表页面</a>
			<a href=index.jsp>返回主页</a>
</body>
</html>