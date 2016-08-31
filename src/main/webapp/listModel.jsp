<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkAll(allC) {
		var otherCs = document.getElementsByName("delId");
		for (var i = 0; i < otherCs.length; i++) {
			otherCs[i].checked = allC.checked;
		}
	}
</script>
</head>
<body style="text-align: center;">
	<h1>样机列表页面</h1>
	<hr>
	<font color="red">${msg }</font>
	<form
		action="${pageContext.request.contextPath }/FindModelByModelName"
		method="POST">
		样机名称:<input type="text" name="ModelName" value="${param.ModelName }" /> 
		<input type="submit" value="条件查询样机" />
	</form>

	
	<table border="1" width="100%">
		<tr>
			<th><input type="checkbox" onclick="checkAll(this)" />样机 ID</th>
			<th>样机名称</th>
			<th>样机版本</th>
			<th>样机说明</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="model">
			<tr>
				<td><input type="checkbox" name="delId"
					value="${model.modelID }" /> ${model.modelID }</td>
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
	<a href=index.jsp>返回主页</a>
</body>
</html>