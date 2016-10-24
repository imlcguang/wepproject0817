<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借机统计</title>
<style>
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
.choice{  
    position: relative;  
}  
.choice .radio{  
    position: relative;  
    display: inline-block;  
    font-weight: 400;  
    color: #0c4757;  
    padding-left: 25px;  
    cursor: pointer;  
} 

.datalist {
	border: 1px solid #0058a3; /* 表格边框 */
	font-family: Arial;
	border-collapse: collapse; /* 边框重叠 */
	background-color: #eaf5ff; /* 表格背景色 */
	font-size: 14px;
}

.datalist caption {
	padding-bottom: 5px;
	font: bold 1.4em;
	text-align: left;
}

.datalist th {
	border: 1px solid #0058a3; /* 行名称边框 */
	background-color: #4bacff; /* 行名称背景色 */
	color: #FFFFFF; /* 行名称颜色 */
	font-weight: bold;
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 12px;
	padding-right: 12px;
	text-align: center;
}

.datalist td {
	border: 1px solid #0058a3; /* 单元格边框 */
	text-align: left;
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 10px;
	padding-right: 10px;
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
	font-size: 18px;
}

body {
	font-family: "Microsoft Yahei";
	font-size: 10.5pt;
	line-height: 1.5;
}
</style>
</head>
<body>
	<div class="head">
		<h2>借还信息</h2>
		<hr>
		<h3>借机统计</h3>
	</div>
	<form action="${pageContext.request.contextPath }/CountServlet"
		method="POST">
		排序方式:<input type="radio" name="Count" value="Cus"
			<c:if test="${param.Count=='Cus'}">checked='checked'</c:if> />按客户 <input
			type="radio" name="Count" value="Model"
			<c:if test="${param.Count=='Model'}">checked='checked'</c:if>>按样机
		<input type="submit" value="排序" />
	</form>
	<br>

	<c:if test="${param.Count=='Cus'}">
		<table border="1" width="60%" class="datalist">
			<tr>
				<th>客户名称</th>
				<th>样机名称</th>
				<th>借机数量</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="map">
				<tr>
					<td rowspan="${map['detail'].size()+1}" align="center"><c:out
							value="${map['cal'].customerID.customerName}" /></td>
					<td><c:out value="${map['cal'].modelID.modelName}" /></td>
					<td><c:out value="${map['cal'].borrowNumber}" /></td>
				</tr>
				<c:forEach items="${map['detail']}" var="value">
					<tr>
						<%-- ${value.customerID.customerName} --%>
						<td><c:out value="${value.modelID.modelName }" /></td>
						<td><c:out value="${value.borrowNumber }" /></td>
					</tr>
				</c:forEach>

			</c:forEach>
		</table>
	</c:if>


	<c:if test="${param.Count=='Model'}">
		<table border="1" width="60%" class="datalist">
			<tr>
				<th>样机名称</th>
				<th>客户名称</th>
				<th>借机数量</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="map">
				<tr>
					<td rowspan="${map['detail'].size()+1}" align="center"><c:out
							value="${map['cal'].modelID.modelName}" /></td>
					<td><c:out value="${map['cal'].customerID.customerName}" /></td>
					<td><c:out value="${map['cal'].borrowNumber}" /></td>
				</tr>
				<c:forEach items="${map['detail']}" var="value">
					<tr>
						<td><c:out value="${value.customerID.customerName}" /></td>
						<td><c:out value="${value.borrowNumber }" /></td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<a href=index.jsp>返回主页</a>
</body>
</html>