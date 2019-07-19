<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="library.vo.BookVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>

	<%
		ArrayList<BookVO> list = (ArrayList<BookVO>) request.getAttribute("list");
		if (!list.isEmpty()) {
	%>
	<table border="1" style="text-align: center">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>분류</th>
			<th>출판사</th>
			<th>저자</th>
			<th>대출 여부</th>
			<th>예약 여부수</th>
			<th><input type = "button" value = "대출"><th>
		</tr>

		<%
			for (int i = 0; i < list.size(); i++) {
					BookVO book = list.get(i);
		%>

		<tr>
			<td><%=book.getNumber()%></td>
			<td><%=book.getName()%></td>
			<td><%=book.getGenre()%></td>
			<td><%=book.getPub()%>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getLent_con()%></td>
			<td><%=book.getReserv()%></td>
		</tr>
		<%
			}
			} else {
				out.print("<h3>등록된 책 정보가 없습니다.</h3>");
			}
		%>


	</table>

	<%@ include file="adminHome.jsp"%>

</body>
</html>