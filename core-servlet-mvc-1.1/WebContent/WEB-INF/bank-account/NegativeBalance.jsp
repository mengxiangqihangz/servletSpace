<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是NegativeBalance.jsp页面</title>
</head>
<body>
	<table border=5 align="center">
		<tr><th class="title">
		We Know Where You Live!
	</table>
	<jsp:useBean id="badCustomer" type="com.mvc.bean.BankCustomer" scope="request" ></jsp:useBean>
	Watch out,
	<jsp:getProperty property="firstName" name="badCustomer"/>
	we know where you live.<p>
	Pay us the$
	<jsp:getProperty property="balance" name="badCustomer"/><br>
	lastName:<jsp:getProperty property="lastName" name="badCustomer"/>
	
	
</body>
</html>