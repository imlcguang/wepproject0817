<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
/* 	font-size: 16px; */
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

body {
	font-family: "Microsoft Yahei";
	font-size: 10.5pt;
	line-height: 1.5;
	 text-align:center;
}

#News-Pagination{
/* width: 177px; 
margin: 0 auto;*/
margin-left:0;
margin-right:0;
display:inline-block;text-align:right;
}





</style>
</head>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<link href="pagination.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="jquery-1.11.3.js"></script>
<script type="text/javascript" src="jquery.pagination.js"></script>
<script type="text/javascript">

// 点击分页按钮以后触发的动作
function handlePaginationClick(pageIndex, pagination_container) {
    $("#userForm").attr("action", "<%=context %>/ListUserServlet?pageIndex=" + (pageIndex+1));
    $("#userForm").submit();
    return false;
}

$(function(){
	$("#News-Pagination").pagination(${totalCount}, {
        items_per_page:10, // 每页显示多少条记录
        current_page:${pageIndex} - 1,// 当前显示第几页数据
        num_display_entries:8, // 分页显示的条目数
        next_text:"下一页",
        prev_text:"上一页",
        num_edge_entries:2, // 连接分页主体，显示的条目数
        callback:handlePaginationClick
	});
});
</script>
<body style="text-align: center;">
	<div class="head" style="text-align: left;">
		<h2>用户信息</h2>
		<hr>
		<h3>用户列表页面</h3>
	</div>
	
	<font color="red">${msg }</font>
	<form
		action="${pageContext.request.contextPath }/FindUserByNameServlet"
		method="POST" id="userForm">
		<select id="getid"  >
		<option value="">请选择用户姓名</option>
			<c:forEach items="${listu}" var="user" >
				<option value="${user.userName }">${user.userName }</option>
			</c:forEach>
		</select> 
		<input type="submit" value="条件查询用户" id="button"/>
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
		<c:forEach items="${recordResult}" var="user">
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
	<br/>
	<div  id="News-Pagination" align="center" ></div>
	<br/><br/>
	共${totalCount}条记录      <a href=index.jsp><input type="button" id="button" value="返回主页"></input></a>
</body>
</html>