<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>样机管理系统</title>
		<style>
			body {
				margin: 0;
				padding: 0;
				font-size: 29px;
				font-weight: bold;
				font-family:"Microsoft Yahei";
			}
			
			div {
				text-align: center;
				line-height: 40px
			}
			a:hover{
                 color:red;
                 font-size:33px;
                
            }
			.head,
			.main {
				width: 960px;
				margin: 0 auto;
				font-weight: bold
			}
			
			.head { 
			    padding-top:5px;
			    height: 130px;  
			    line-height: 30px;  
			    font-size: 25px;
				background: #FFFFCC;
				font-weight: bold;
			}
			
			.main {
				height: 530px;
			}
			
			.quarter-div {
				width: 50%;
				height: 50%;
				float: left;
			}
			
			.left1 {
				background-color: #ccc;
				border-radius:20px;
			}
			
			.left2 {
				background-color: #FCC;
				border-radius:20px;
			}
			
			.right1 {
				background-color: #CCFFCC;
				border-radius:20px;
			}
			
			.right2 {
				background-color: #FFFF99;
				border-radius:20px;
			}
		</style>
	</head>

	<body>
			<c:if test="${sessionScope.regUser==null}">
		<div class="head">
			<h1 style="text-align:center">样机管理系统</h1>
				<p>欢迎光临!游客!
				<a href="${pageContext.request.contextPath }/user.jsp">用户注册</a>
				<a href="${pageContext.request.contextPath }/login.jsp">用户登录</a></p>
		</div>
			</c:if>

			<c:if test="${sessionScope.regUser!=null}">
			<div class="head">
			<h1 style="text-align:center">样机管理系统</h1>
		<p>	欢迎回来!${sessionScope.regUser.loginName }!
				<a href="${pageContext.request.contextPath }/OutServlet">注销</a></p>
			</div>
			</c:if>
				
		<div class="main">
		<c:if test="${sessionScope.regUser!=null}">
			<div class="quarter-div left1">
				<p>用户信息</p>
				<a href=user.jsp>注册用户信息</a><br />
				<a href=${pageContext.request.contextPath}/ListUserServlet>用户信息管理</a>
			</div>
			<div class="quarter-div left2">
				<p>客户信息</p>
				<a href=customer.jsp>注册客户信息</a><br />
				<a href=${pageContext.request.contextPath}/ListCustServlet>客户信息管理</a>
			</div>
			<div class="quarter-div right1">
				<p>样机信息</p>
				<a href=model.jsp>注册样机信息</a><br />
				<a href=${pageContext.request.contextPath}/ListModelServlet>样机信息管理</a>
			</div>

			<div class="quarter-div right2">
				<p>借还信息</p>
				<a href=borrow.jsp>借机登记</a><br />
				<a href=${pageContext.request.contextPath}/ListBorrowServlet>借机明细查询</a><br />
				<a href=count.jsp>借机统计</a>
			</div>
			</c:if>
		</div>
	
	</body>

</html>