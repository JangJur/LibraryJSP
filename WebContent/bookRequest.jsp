<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>생성</title>
<link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<body>

	<h3>도서 신청 페이지입니다.</h3>

	${ error }

	<form action="BookRequest.do" method="post">
		<table>
			<tr>
				<td>책이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>분류</td>
				<td>
        			<select name="class">
	            		<option value="0">----선택----</option>
	           			<option value="사회과학">사회과학</option>
			            <option value="순수과학">순수과학</option>
			            <option value="기술과학">기술과학</option>
			            <option value="예술">예술</option>
			            <option value="언어">언어</option>
         			</select>
         </form></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="pub"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>신청학생 학번</td>
				<td><input type="text" name="stu_id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="신청" /></td>
			</tr>
			<tr>
				<td><input type="button" onclick="location.href='studentMain.jsp'" value="사용자화면으로 이동"/></td>
			</tr>
			
		</table>

	</form>

</body>
</html>