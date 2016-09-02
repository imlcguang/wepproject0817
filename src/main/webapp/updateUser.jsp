<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
<h1>用户信息维护：修改用户信息</h1>
	<hr>
	<form
		action="${pageContext.request.contextPath }/UpdateUserServlet"  method="POST">
		<font color="red">${msg }</font>
    <input type="hidden" name="id" value="${user.userID }">
    <input type="hidden" name="Password" value="${user.password }">
     <input type="hidden" name="Password2" value="${user.password2 }">
      <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">登录名：</td>
			    	<td class="controler"><input type="text" name="LoginName" value="${user.loginName }"readonly="readonly" style="background: silver"/></td>
			    </tr>
			    <%-- <tr>
			    	<td class="label">密码： </td>
			    	<td class="controler"><input type="password" name="Password" value="${user.password }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">确认密码：</td>
			    	<td class="controler"><input type="password" name="Password2" value="${user.password2 }"></td>
			    	
			    </tr> --%>
			    <tr>
			    	<td class="label">用户名：</td>
			    	<td class="controler"><input type="text" name="UserName" value="${user.userName}"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label" >性别：</td>
			    	<td class="controler" >
			    	<input type="radio" name="UserSex" checked="checked" value="Male" 
			    	<c:if test="${user.userSex=='Male'}">checked='checked'</c:if>
			    	/>Male
			    	<input type="radio" name="UserSex" value="Female"
			    	<c:if test="${user.userSex=='Female'}">checked='checked'</c:if>
			    	/>Female</td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">权限：</td>
			    	<td class="controler">
			    	<!-- 复选框回显 -->
			    	<input type="checkbox" name="FunctionPopedom" value="1" 
			    	<c:if test="${fn:contains(1,fn:substring(user.functionPopedom, 0, 1))==true}">checked='checked'></c:if>
			    	/> 借机登记 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="2" 
			    	  <c:if test="${fn:contains(1,fn:substring(user.functionPopedom, 1, 2))==true}">checked='checked'</c:if>
			    	 /> 样机归还 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="3" 
			    	  <c:if test="${fn:contains(1,fn:substring(user.functionPopedom, 2, 3))==true}">checked='checked'</c:if>
			    	 />客户信息维护 &nbsp;<br/>
			    	  <input type="checkbox" name="FunctionPopedom" value="4" 
			    	  <c:if test="${fn:contains(1,fn:substring(user.functionPopedom, 3, 4))==true}">checked='checked'</c:if>
			    	 /> 样机信息维护 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="5" 
			    	  <c:if test="${fn:contains(1,fn:substring(user.functionPopedom, 4, 5))==true}">checked='checked'</c:if>
			    	 /> 借机明细查询 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="6" 
			    	  <c:if test="${fn:contains(1,fn:substring(user.functionPopedom, 5, 6))==true}">checked='checked'</c:if>
			    	 /> 借机统计 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="7" 
			    	  <c:if test="${fn:contains(1,fn:substring(user.functionPopedom, 6, 7))==true}">checked='checked'</c:if>
			    	 /> 用户信息管理 &nbsp;
			    	</td>
			    </tr>
		
			    	<td colspan="2" align="center">
			    		<input type="submit" value="修改"/>&nbsp;&nbsp;
			    	    <input type="reset" value="取消"/>&nbsp;&nbsp;
			    	</td>
			    </tr>
			  </table>
			  	</form>
</body>
</html>