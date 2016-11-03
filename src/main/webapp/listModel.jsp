<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>样机列表</title>
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
	text-decoration: none;
}

a:hover {
	color: red;

}

body {
	font-family: "Microsoft Yahei";
	font-size: 10.5pt;
	line-height: 1.5;
}
#News-Pagination{
width: 180px;
margin: 0 auto;
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
    $("#modelForm").attr("action", "<%=context %>/ListModelServlet?pageIndex=" + (pageIndex+1));
    $("#modelForm").submit();
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
		<h2>借还信息</h2>
		<hr>
		<h3>样机列表</h3>
	</div>

	<font color="red">${msg }</font>
	<form action="${pageContext.request.contextPath }/FindModelByModelName"
		method="POST" id="modelForm">
		样机名称:<input type="text" name="ModelName" value="${param.ModelName }" />
		<input type="submit" value="条件查询样机" />
	</form>


	<table border="1" width="100%" class="datalist">
		<tr>
			<th>样机 ID</th>
			<th>样机名称</th>
			<th>样机版本</th>
			<th>样机说明</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${recordResult}" var="model">
			<tr>
				<td><c:out value="${model.modelID }" /></td>
				<td><c:out value="${model.modelName }" /></td>
				<td><c:out value="${model.modelVersion }" /></td>
				<td><c:out value="${model.modelDesc }" /></td>

				<td><a
					href="${pageContext.request.contextPath }/ModelInfoServlet?id=${model.modelID }">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/DelModelServlet?id=${model.modelID }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<div  id="News-Pagination" align="center" ></div>
	<br/><br/>
	共${totalCount}条记录    <a href=index.jsp >返回主页</a>
	
	
	
</body>
</html>