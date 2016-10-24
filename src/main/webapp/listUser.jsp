<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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

.datalist {
	border: 1px solid #0058a3; /* 表格边框 */
	font-family: Arial;
	border-collapse: collapse; /* 边框重叠 */
	background-color: #eaf5ff; /* 表格背景色 */
	font-size: 14px;
	line-height: 25px;
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
	font-size: 16px;
}

body {
	font-family: "Microsoft Yahei";
	font-size: 10.5pt;
	line-height: 1.5;
}
</style>
</head>
<body style="text-align: center;">
	<div class="head" style="text-align: left;">
		<h2>用户信息</h2>
		<hr>
		<h3>用户列表页面</h3>
	</div>
	
	<font color="red">${msg }</font>
	<form
		action="${pageContext.request.contextPath }/FindUserByNameServlet"
		method="POST">
		<select name="getid"  >
		<option value="">请选择用户姓名</option>
			<c:forEach items="${listu}" var="user" >
				<option value="${user.userName }">${user.userName }</option>
			</c:forEach>
		</select> 
		<input type="submit" value="条件查询用户" />
	</form>

	<p>权限备注：1（有权限），0（无权限）。功能按顺序分别为用户信息管理、借机统计、借机明细查询、样机信息维护、客户信息维护、样机归还、借机登记</p>
	<table border="1" width="100%" class="datalist" >
		<tr>
			<th>用户 ID</th>
			<th>登录名</th>
			<th>用户姓名</th>
			<th>用户性别</th>
			<th>权限</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${listu}" var="user">
			<tr>
				<td> <c:out value="${user.userID }" /></td>
				<td><c:out value="${user.loginName }" /></td>
				<td><c:out value="${user.userName }" /></td>
				<td><c:out value="${user.userSex }" /></td>
				<td><c:out value="${user.functionPopedom }" /></td>

				<td><a
					href="${pageContext.request.contextPath }/UserInfoServlet?id=${user.userID }">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/DelUserServlet?id=${user.userID }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href=index.jsp>返回主页</a>
</body>
</html>