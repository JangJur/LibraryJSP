<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>생성 결과</title>
</head>
<body>
	<%
      String charge = request.getAttribute("count").toString();
	  System.out.println(charge);
   	%>
	<h3> 반납 완료되었습니다. 연체료는<%=charge%>원입니다.</h3>
	<%@ include file="adminHome.jsp" %>
	
</body>
</html>