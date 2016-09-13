<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改借机信息</title>
</head>
<body>
<h1>借还信息</h1><hr>
 <h2>借机修改</h2>
  <font color="red">${msg }</font>
   <form name="BorForm" action="${pageContext.request.contextPath}/UpdateBorrowServlet" method="post" >
    <%-- <%=request.getContextPath()%>  --%>
    <input type="hidden" name="id" value="${borrow.borrowNo }">
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">客户ID：</td>
			    	<td class="controler"><input type="text" id="CustomerID" name="CustomerID"value="${borrow.customerID.customerID }"/></td>
			    </tr>
			    <tr>
			    	<td class="label">发货时间： </td>
			    	<td class="controler"><input type="text" id="SendDatetime" name="SendDatetime" value="${borrow.sendDatetime }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">批准人ID：</td>
			    	<td class="controler"><input type="text" id="BorrowPermitPerson" name="BorrowPermitPerson" value="${borrow.borrowPermitPerson.userID }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">借机操作员ID：</td>
			    	<td class="controler"><input type="text" id="BorrowOperator" name="BorrowOperator" value="${borrow.borrowOperator.userID }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">预计归还时间：</td>
			    	<td class="controler"><input type="text" id="PlanReturnDatetime" name="PlanReturnDatetime" value="${borrow.planReturnDatetime }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">样机ID：</td>
			    	<td class="controler"><input type="text" id="ModelID" name="ModelID" value="${borrow.modelID.modelID }"></td>
			    </tr>
			     <tr>
			    	<td class="label">借机数量：</td>
			    	<td class="controler"><input type="text" id="BorrowNumber" name="BorrowNumber" value="${borrow.borrowNumber }"></td>
			    </tr>
			     <tr>
			    	<td class="label">借条编号：</td>
			    	<td class="controler"><input type="text" id="BorrowCheckNo" name="BorrowCheckNo" value="${borrow.borrowCheckNo }"></td>
			    </tr>
			     
			     <tr>
			    	<td class="label">归还操作员：</td>
			    	<td class="controler"><input type="text" id="ReturnOperator" name="ReturnOperator" value="${borrow.returnOperator.userID }"></td>
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
			<a href=ListBorrowServlet>返回借机明细列表页面</a>
			  	<a href=index.jsp>返回主页</a>
</body>
</html>