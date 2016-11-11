<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改样机信息</title>
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
		<h2>样机信息</h2>
		<hr>
		<h3>修改信息</h3>
	</div>
	<br>
	<form
		action="${pageContext.request.contextPath }/UpdateModelServlet"  method="POST" class="datalist">
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
			    	<td colspan="2" align="center">
			    		<input type="submit" value="修改" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	    <input type="reset" value="取消" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	   
			    	</td>
			    </tr>
			  </table>
			</form>
			<br>
			   <a href=index.jsp><input type="button" id="button" value="返回主页"></input></a>
			    	     <a href=ListModelServlet><input type="button" id="button" value="返回样机列表页面"></input></a>
</body>
</html>