<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>생성</title>
</head>
<body>

	<h3>회원 가입</h3>

	${ error }

	<form action="studentInsert.do" method="post">
		<table>
			<tr>
				<td>학번</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td><select name="class">
	           			<option value="재학">재학</option>
			            <option value="졸업">졸업</option>
         			</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="가입" /></td>
			</tr>
		</table>

	</form>

</body>
</html>