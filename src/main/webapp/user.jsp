<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
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
	width:680px;
}
.datalist td {
	/* border: 1px solid #0058a3; */  /* 单元格边框 */
	text-align: left;
	padding-top: 8px;
	padding-bottom: 8px;
	padding-left: 13px;
	padding-right: 13px;
	font-weight: bold;
} 

.datalist tr.altrow {
	background-color: #c7e5ff; /* 隔行变色 */
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
<head>
    
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	 .label{
		  width: 20%	
	 }
	 .controler{
		  width: 80%	
	 }
   </style>  
   <script type="text/javascript">
  		function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
  	</script>
   <!-- <script type="text/javascript" src="js/Calendar3.js"></script> -->
  </head>
  
  <body >
  <div class="head">
		<h2>用户信息</h2>
		<hr>
		<h3>用户注册</h3>
	</div>
	<br>
    <font color="red">${msg }</font>
    <form name="regForm" action="${pageContext.request.contextPath}/UserServlet" method="post" class="datalist">
    <%-- <%=request.getContextPath()%>  --%>
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			    <tr>
			    	<td class="lalel">登录名：</td>
			    	<td class="controler"><input type="text" name="LoginName" value="${param.LoginName }"/></td>
			    </tr>
			    <tr>
			    	<td class="label">密码： </td>
			    	<td class="controler"><input type="password" name="Password" ></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">确认密码：</td>
			    	<td class="controler"><input type="password" name="Password2" ></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">用户名：</td>
			    	<td class="controler"><input type="text" name="UserName" value="${param.UserName}"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label" >性别：</td>
			    	<td class="controler" >
			    	<input type="radio" name="UserSex" checked="checked" value="Male" >Male
			    	<input type="radio" name="UserSex" value="Female">Female</td>
			    	
			    </tr>
			   
			   <!--  <tr>
			    	<td class="label">出生日期：</td>
			    	<td class="controler">
			    	  <input name="birthday" type="text" id="control_date" size="10"
                      maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" />
			    	</td>
			    </tr> -->
			 
		
			    <tr>
			    	<td class="label">权限：</td>
			    	<td class="controler">
			    	<input type="checkbox" name="FunctionPopedom" value="1" > 借机登记 &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="2" > 样机归还 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="3" >客户信息维护 &nbsp;<br/>
			    	  <input type="checkbox" name="FunctionPopedom" value="4" > 样机信息维护 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="5" > 借机明细查询 &nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="6" > 借机统计 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	  <input type="checkbox" name="FunctionPopedom" value="7" > 用户信息管理 &nbsp;
			    	</td>
			    </tr>
			   
			    <tr>
  				     <td>验证码</td>
  				     <td><input type="text" name="valistr" /> <img src="${pageContext.request.contextPath }/ValiImg" style="cursor: pointer" onclick="changeImg(this)"/></td>
  			    </tr>
  			
  				    
  			      
  			 <tr>
			    	<td colspan="2" align="center">
			    		<input type="submit" value="注册" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	    <input type="reset" value="取消" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	    <a href=index.jsp><input type="button" id="button" value="返回主页"></input></a>
			    	</td>
			    </tr>
			
			  </table>
			</form>
		
  </body>
</html>