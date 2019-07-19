<%@page import="library.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 검색 및 대출 예약</title>
<link href="css/table.css" rel="stylesheet" type="text/css">
<script>
   function searchCheck(frm){
      if(frm.keyWord.value==""){
         alert("검색 단어를 입력하세요.");
         frm.keyWord.focus();
         return;
      }
      frm.submit();
   }</script>
</head>
<body>
	<%
		ArrayList<BookVO> list = (ArrayList<BookVO>) request.getAttribute("list");
		
	%>
	<table>
		<tr>
			<th>도서번호</th>
			<th>제목</th>
			<th>분류</th>
			<th>출판사</th>
			<th>저자</th>
			<th>대출</th>
			<th>예약</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
		</tr>

		<%
			for (int i = 0; i < list.size(); i++) {
				BookVO book = list.get(i);
		%>
		<tr>
			<td><%=book.getNumber()%></td>
			<td><%=book.getName()%></td>
			<td><%=book.getGenre()%></td>
			<td><%=book.getPub()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getLent_con()%></td>
			<td><%=book.getReserv()%></td>
			<td><a href="RentInsert.do?id=${sessionID}&book_num=<%=book.getNumber()%>">대출하기</a></td>
			<td><a href="ReserveInsert.do?id=${sessionID}&book_num=<%=book.getNumber()%>">예약하기</a></td>
		</tr>

		<%
			}
		%>
	</table>
	<%@ include file="/bookSearch.jsp"%><input type="button" onclick="location.href='studentMain.jsp'" value="사용자화면으로 이동"/>
</body>
</html>