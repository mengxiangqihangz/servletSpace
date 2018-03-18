<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是HighBalance.jsp页面</title>
</head>
<body>
	
	<jsp:useBean id="eliteCustomer" type="com.mvc.bean.BankCustomer" scope="request" ></jsp:useBean>
	It is an honor to serve you,
	<jsp:getProperty property="firstName" name="eliteCustomer"/>
	<jsp:getProperty property="lastName" name="eliteCustomer"/><p>
	<jsp:getProperty property="id" name="eliteCustomer"/>
	<jsp:getProperty property="balance" name="eliteCustomer"/>
</body>
</html>