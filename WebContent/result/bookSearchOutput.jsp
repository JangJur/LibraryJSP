<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
</head>
<body>
	<h3>검색 결과</h3>
	
	<%
		String result = (String)request.getAttribute("result");
	
		if(result != null)
			out.print(result+"<p>");
		else {
	%>		
	
		<h3>
		${ student.id } / ${ student.name } / ${ student.pwd } / ${ student.tel }
		</h3>
	<% } %>
	
	<%@ include file="loginHome.jsp" %>
</body>
</html>