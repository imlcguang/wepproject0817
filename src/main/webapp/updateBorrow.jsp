<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改借机信息</title>
<style>
.label {
	width:20%;
}

.controler {
width:80%;
	
}

.head {
	/* width: 960px;
	 font-weight: bold padding-top:3px; */
	margin: 0 auto;
	height: 140px;
	line-height: 15px;
	font-size: 25px;
	background: #FFFFCC;
	font-weight: bold;
	border-style: solid;
	border-color: #FFFFCC;
}
.table{
width:30%;
}
.datalist {
border-radius:8px;
	border: 1px solid #0058a3;  /* 表格边框 */ 
	font-family: Arial;
	border-collapse: collapse; /* 边框重叠 */
	background-color: #eaf5ff; /* 表格背景色 */
	font-size: 14px;
	width:466px;
}
.datalist td {
	/* border: 1px solid #0058a3; */  /* 单元格边框 */
	text-align: left;
	padding-top: 6px;
	padding-bottom: 6px;
	padding-left: 13px;
	padding-right: 13px;
	font-weight: bold;
} 

.datalist tr.altrow {
	background-color: #c7e5ff; /* 隔行变色 */
}

a {
	font-weight: bold;
	  text-decoration:none;
}

a:hover {
	color: red;
	font-size: 14px;
}

body {
	font-family: "Microsoft Yahei";
	font-size: 10.5pt;
	line-height: 1.5;
}
.main{
width:40%;
text-align:left;
}

#button {
  display: inline-block;
  padding: 3px 9px;
  font-size: 13px;
  cursor: pointer;
  text-align: center;   
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #3798F9;
  border: none;
  border-radius: 15px;
  box-shadow: 0 4px #999;
}

#button:hover {background-color:  #CBCBCB} 
#button:active {
  background-color:   #CBCBCB;
  box-shadow: 0 3px #666;
  transform: translateY(2px);
}

</style>
</head>
<body>
<div class="head">
		<h2>借还信息</h2>
		<hr>
		<h3>修改信息</h3>
	</div>
	<br>
  <font color="red">${msg }</font>
   <form name="BorForm" action="${pageContext.request.contextPath}/UpdateBorrowServlet" method="post" class="datalist">
    <%-- <%=request.getContextPath()%>  --%>
    <input type="hidden" name="id" value="${borrow.borrowNo }">
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">客户：</td>
			    	<td class="controler"><select name="CustomerID">
						<option value="${borrow.customerID.customerID}">${borrow.customerID.customerName }</option>
						<c:forEach items="${listc}" var="cust">
							<option value="${cust.customerID }">${cust.customerName }</option>
						</c:forEach>
				</select></td>
			    </tr>
			    <tr>
			    	<td class="label">发货时间： </td>
			    	<td class="controler"><input type="text" id="SendDatetime" name="SendDatetime" value="${borrow.sendDatetime }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">批准人：</td>
			    	<td class="controler"><select name="BorrowPermitPerson">
						<option value="${borrow.borrowPermitPerson.userID}">${borrow.borrowPermitPerson.userName}</option>
						<c:forEach items="${listu}" var="user">
							<option value="${user.userID }">${user.userName }</option>
						</c:forEach>
				</select></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">借机操作员：</td>
			    	<td class="controler"><select name="BorrowOperator">
						<option value="${borrow.borrowOperator.userID}">${borrow.borrowOperator.userName}</option>
						<c:forEach items="${listu}" var="user">
							<option value="${user.userID }">${user.userName }</option>
						</c:forEach>
				</select></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">预计归还时间：</td>
			    	<td class="controler"><input type="text" id="PlanReturnDatetime" name="PlanReturnDatetime" value="${borrow.planReturnDatetime }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">样机：</td>
			    	<td class="controler"><select name="ModelID">
						<option value="${borrow.modelID.modelID}">${borrow.modelID.modelName}</option>
						<c:forEach items="${listm}" var="model">
							<option value="${model.modelID }">${model.modelName }</option>
						</c:forEach>
				</select></td>
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
			    	<td class="controler"><select name="ReturnOperator">
						<option value="${borrow.returnOperator.userID}">${borrow.returnOperator.userName}</option>
						<c:forEach items="${listu}" var="user">
							<option value="${user.userID }">${user.userName }</option>
						</c:forEach>
				</select></td>
			    </tr>
			   <tr>
			    	<td colspan="2" align="center">
			    		<input type="submit" value="修改" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	    <input type="reset" value="取消" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	   
			    	</td>
			    </tr>
			  </table>
			</form>
			<br>
			   <a href=index.jsp><input type="button" id="button" value="返回主页"></input></a>
			    	     <a href=ListBorrowServlet><input type="button" id="button" value="返回借机明细列表"></input></a>
</body>
</html>