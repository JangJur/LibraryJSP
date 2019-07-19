<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="library.vo.StudentVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정 정보 검색</title>
<link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<body>

	${ error }

	<%
		StudentVO student = (StudentVO) request.getAttribute("student");

		if (student != null) {
	%>
	<h3>회원정보 수정</h3>

	<form action="studentUpdate.do" method="post">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="id" readonly
					value="${ student.id }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${ student.name }"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" value="${ student.pwd }"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" value="${ student.tel }"></td>
			</tr>
			<tr>
				<td>연체 횟수</td>
				<td><input type="text" name="ovd_cnt"
					value="${student.ovd_cnt}"></td>
			</tr>
			<tr>
				<td>대출 제한 여부</td>
				<td><input type="text" name="len_con"
					value="${student.len_con}"></td>
			</tr>
			<tr>
				<td>대출 가능 권수</td>
				<td><input type="text" name="len_pos"
					value="${student.len_pos}"></td>
			</tr>
			<tr>
				<td>상태</td>
				<td><input type="text" name="con" value="${student.con}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
	${ result }
	<p>
		<%
			}
		%>
	
</body>
</html>