<%@page import="library.vo.BookReqVO"%>
<%@page import="library.vo.RentallVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="library.vo.StudentVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>

	<%
		ArrayList<BookReqVO> list = (ArrayList<BookReqVO>) request.getAttribute("list");
		if (!list.isEmpty()) {
	%>
	<form method="post" action = "BookInsert.do">
		<table border="1" style="text-align: center">
			<tr>
				<th>순번</th>
				<th>책이름</th>
				<th>출판사</th>
				<th>저자</th>
				<th>분류</th>
				<th>신청자 학번</th>
				<th></th>

				<%
					for (int i = 0; i < list.size(); i++) {
							BookReqVO book = list.get(i);
				%>
			
			<tr>
				<td><%=book.getNum()%></td>
				<td><%=book.getBook_name()%></td>
				<td><%=book.getBook_pub()%></td>
				<td><%=book.getBook_auth()%></td>
				<td><%=book.getBook_class()%></td>
				<td><%=book.getStu_id()%></td>
				<td><a href="bookInsert.do?id=<%=book.getNum()%>">책 신청하기</a></td>
			</tr>
			<%
				}
				} else {
					out.print("<h3>등록된 책 신청 정보가 없습니다.</h3>");
				}
			%>


		</table>
	</form>

	<form action="studentSearch.do" method="post">
		학번 : <input type="text" name="id" /> <input type="hidden" name="job"
			value="update" /> <input type="submit" value="검색" />

		<%@ include file="adminHome.jsp"%>
	</form>

</body>
</html>