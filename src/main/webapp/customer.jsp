<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户注册</title>
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
width:40%;
}
.datalist {
border-radius:8px;
	border: 1px solid #0058a3;  /* 表格边框 */ 
	font-family: Arial;
	border-collapse: collapse; /* 边框重叠 */
	background-color: #eaf5ff; /* 表格背景色 */
	font-size: 14px;
	width:336px;
}
.datalist td {
border-radius:8px;
	/* border: 1px solid #0058a3; */  /* 单元格边框 */
	text-align: left;
	padding-top: 6px;
	padding-bottom: 6px;
	padding-left: 12px;
	padding-right: 12px;
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
		<h2>客户信息</h2>
		<hr>
		<h3>客户注册</h3>
	</div>
	<br>
<font color="red">${msg }</font>
   <form name="CusForm" action="${pageContext.request.contextPath}/CusServlet" method="post" class="datalist">
    <%-- <%=request.getContextPath()%>  --%>
			  <table border="0" width="800" cellspacing="0" cellpadding="0" >
			    <tr>
			    	<td class="lalel">客户名：</td>
			    	<td class="controler"><input type="text" name="CustomerName"value="${param.CustomerName }"/></td>
			    </tr>
			    <tr>
			    	<td class="label">联系人姓名： </td>
			    	<td class="controler"><input type="text" name="RelationName" value="${param.RelationName }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">联系电话：</td>
			    	<td class="controler"><input type="text" name="RelationPhone" value="${param.RelationPhone }"></td>
			    	
			    </tr>
			    <tr>
			    	<td class="label">地址：</td>
			    	<td class="controler"><input type="text" name="Address" value="${param.Address }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">邮箱：</td>
			    	<td class="controler"><input type="text" name="Email" value="${param.Email }"></td>
			    </tr>
			    
			    <tr>
			    	<td class="label">备注：</td>
			    	<td class="controler"><input type="text" name="Remark" value="${param.Remark }"></td>
			    </tr>
			  <tr>
			    	<td colspan="3" align="center">
			    		<input type="submit" value="注册" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	    <input type="reset" value="取消" id="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	    <a href=index.jsp><input type="button" id="button" value="返回主页"></input></a>

			    	</td>
			    </tr>
			  </table>
			    		
			</form>
</body>
</html>