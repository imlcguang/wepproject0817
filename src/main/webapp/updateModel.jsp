<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>样机信息维护：修改样机信息</h1>
	<hr>
	<form
		action="${pageContext.request.contextPath }/UpdateModelServlet"  method="POST">
		<font color="red">${msg }</font>
    <%-- <%=request.getContextPath()%>  --%>
    <input type="hidden" name="id" value="${model.modelID }">
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">样机名称：</td>
			    	<td class="controler"><input type="text" name="modelName"value="${model.modelName }" readonly="readonly" style="background: silver"/></td>
			    </tr>
			    <tr>
			    	<td class="label">样机版本： </td>
			    	<td class="controler"><input type="text" name="modelVersion" value="${model.modelVersion }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">样机说明：</td>
			    	<td class="controler"><input type="text" name="modelDesc" value="${model.modelDesc }"></td>
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