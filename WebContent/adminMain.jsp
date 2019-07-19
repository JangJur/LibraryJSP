<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="library.vo.StudentVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1 style="text-align: center">관리자 님 어서오세요.</h1>
	<form>
		<table>
			<td><input type="button" value="학생 관리"
				onclick="location.href='studentList.do'"></td>
			<td><input type="button" value="도서 관리"
				onclick="location.href='bookList.do'"></td>
			<td><input type="button" value="대출 관리"
				onclick="location.href='rentall.do'"></td>
			<td><input type="button" value="도서 신청 관리"
				onclick="location.href='RequestList.do'"></td>	
			<td><input type="button" value="로그아웃"
				onclick="location.href='login.jsp'"></td>
		</table>
	</form>
</body>
</html>