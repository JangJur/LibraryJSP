<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="library.vo.StudentVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1 style="text-align: center">${sessionID} 님 어서오세요.</h1>
	<form>
		<table>
			<td><input type="button" value="검색페이지"
				onclick="location.href='BookSearch.do'"></td>
			<td><input type="button" value="대출조회페이지"
				onclick="location.href ='rentstuall.do?id=${sessionID}'"></td>
			<td><input type="button" value="예약조회페이지"
				onclick="location.href='reserveSearchstu.do?id=${sessionID}'"></td>
			<td><input type="button" value="도서신청페이지"
				onclick="location.href='bookRequest.jsp'"></td>
			<td><input type="button" value="로그아웃"
				onclick="location.href='login.jsp'"></td>
		</table>
	</form>
</body>
</html>