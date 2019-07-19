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
		ArrayList<RentallVO> list = (ArrayList<RentallVO>) request.getAttribute("list");
		if (!list.isEmpty()) {
	%>
	<form action="studentSearch.do" method="post">
		<table border="1" style="text-align: center">
			<tr>
				<th>대출번호</th>
				<th>책이름</th>
				<th>분류</th>
				<th>학번</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>대출일자</th>
				<th>반납일자</th>
				<th></th>

				<%
					for (int i = 0; i < list.size(); i++) {
							RentallVO rent = list.get(i);
				%>
			
			<tr>
				<td><%=rent.getRent_id()%></td>
				<td><%=rent.getBook_name()%></td>
				<td><%=rent.getBook_sort()%></td>
				<td><%=rent.getStu_id()%></td>
				<td><%=rent.getStu_name()%></td>
				<td><%=rent.getTel()%></td>
				<td><%=rent.getRent_date()%></td>
				<td><%=rent.getRet_date()%></td>
				<td><input type="button" onclick = "location.href ='return.do?id=<%=rent.getRent_id()%>&stu_id=<%=rent.getStu_id()%>&return=<%=rent.getRet_date()%>'" value="반납" /> 
			</tr>
			<%
				}
				} else {
					out.print("<h3>등록된 대출 정보가 없습니다.</h3>");
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