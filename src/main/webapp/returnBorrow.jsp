<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>归还登记</title>
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
	width:333px;
}
.datalist td {
	/* border: 1px solid #0058a3; */  /* 单元格边框 */
	text-align: left;
	padding-top: 6px;
	padding-bottom: 15px;
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
<div class="head" style="text-align: left;">
		<h2>借还信息</h2>
		<hr>
		<h3>归还样机</h3>
	</div>
  <font color="red">${msg }</font>
   <form name="BorForm" action="${pageContext.request.contextPath}/ReturnServlet" method="post" class="datalist">
    <%-- <%=request.getContextPath()%>  --%>
			  <table border="0" width="800" cellspacing="0" cellpadding="0">
			     <tr>
			    	<td class="label"></td>
			    	<td class="controler"><input type="hidden" id="id"  name="id" value="${param.id }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">借机操作员ID：</td>
			    	<td class="controler"><input type="text" id="ReturnOperator" name="ReturnOperator" value="${param.ReturnOperator }"></td>
			 <tr>
			    	<td colspan="2" align="center">
			    		<input type="submit" value="注册" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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