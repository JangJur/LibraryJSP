<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="library.vo.BookVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 정보 검색(도서)</title>
<link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<body>

	${ error }

	<%
		BookVO book = (BookVO) request.getAttribute("book");

		if (book != null) {
	%>
	<h3 style="text-align: center">도서 정보 수정</h3>

	<form action="bookUpdate.do" method="post">
		<table>
			<tr>
				<td>도서번호</td>
				<td><input type="text" name="book_num" readonly
					value="${ book.number }" readonly ></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><input type="text" name="book_name" value="${ book.name }"></td>
			</tr>
			<tr>
				<td>분류</td>
				<td><input type="text" name="book_class"
					value="${ book.genre }"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="book_pub" value="${ book.pub }"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="book_author"
					value="${book.author}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
	<%
		} else {
			out.print("<h3>등록된 책 정보가 없습니다.</h3>");
		}
	%>


</body>
</html>