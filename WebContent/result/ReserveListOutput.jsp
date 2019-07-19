<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="library.vo.ReserveallVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>

   <%
      ArrayList<ReserveallVO> list = (ArrayList<ReserveallVO>) request.getAttribute("list");
      if (!list.isEmpty()) {
   %>
   <form>
      <table border="1" style="text-align: center">
         <tr>
            <th>학번</th>
            <th>이름</th>
            <th>책 고유번호</th>
            <th>책 이름</th>
            <th>예약 날짜</th>
            <th></th>

            <%
               for (int i = 0; i < list.size(); i++) {
                     ReserveallVO all = list.get(i);
            %>
         
         <tr>
            <td><%=all.getStu_id()%></td>
            <td><%=all.getStu_name()%></td>
            <td><%=all.getBook_num()%></td>
            <td><%=all.getBook_name()%></td>
            <td><%=all.getReserve_date()%></td>
            <td><input type = button onclick = "onclick=location.href='reservedelete.do?booknum=<%=all.getBook_num()%>'" value = "예약취소"></td>
         </tr>
         <%
            }
            } else {
				out.print("<h3>등록된 예약 정보가 없습니다.</h3>");
			}
         %>


      </table>
   </form>

   <%@ include file="/result/studentHome.jsp"%>

</body>
</html>