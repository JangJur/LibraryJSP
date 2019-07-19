<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="library.vo.StudentVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
<link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<body>

   <%
      ArrayList<StudentVO> list = (ArrayList<StudentVO>) request.getAttribute("list");
      if (!list.isEmpty()) {
   %>
   <form>
      <table border="1" style="text-align: center">
         <tr>
            <th>학번</th>
            <th>이름</th>
            <th>비밀번호</th>
            <th>전화번호</th>
            <th>연체 횟수</th>
            <th>대출 가능 여부</th>
            <th>대출 가능 권수</th>
            <th>상태</th>
            <th></th>

            <%
               for (int i = 0; i < list.size(); i++) {
                     StudentVO student = list.get(i);
            %>
         
         <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getPwd()%></td>
            <td><%=student.getTel()%></td>
            <td><%=student.getOvd_cnt()%></td>
            <td><%=student.getLen_con()%></td>
            <td><%=student.getLen_pos()%></td>
            <td><%=student.getCon()%></td>
            <td><a href="studentSearch.do?id=<%=student.getId()%>&job=update">수정</a></td>
         </tr>
         <%
            }
            } else {
               out.print("<h3>등록된 학생 정보가 없습니다.</h3>");
            }
         %>


      </table>
   </form>

   <%@ include file="/studentSearch.jsp"%>

</body>
</html>