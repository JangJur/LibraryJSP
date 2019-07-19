<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>조회</title>
<link href="css/table.css" rel="stylesheet" type="text/css">

</head>
<body>
	
	${ error }
	
	<form action="studentSearch.do" method="post" style="border: 0px">
		학번 : <input type="text" name="id" />
		<input type="hidden" name="job" value="update" />
		<input type="submit" value="검색" />
		<%@ include file="/result/adminHome.jsp" %>
	</form>

</body>
</html>