<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="library.dao.StudentDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 인코딩 처리
		request.setCharacterEncoding("UTF-8");

		// 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String user = request.getParameter("user");
		// DB에서 아이디, 비밀번호 확인
		StudentDAO dao = StudentDAO.getInstance();
		boolean checkUser = false;

		if (user.equals("admin"))
			checkUser = true;

		int check = dao.loginCheck(id, pwd, checkUser);

		// URL 및 로그인관련 전달 메시지
		String msg = "";

		if (checkUser == false) {
			if (check == 1) // 로그인 성공
			{
				// 세션에 현재 아이디 세팅
				session.setAttribute("sessionID", id);
				System.out.println(id);
				msg = "studentMain.jsp";
			} else if (check == 0) // 비밀번호가 틀릴경우
			{
				msg = "login.jsp?msg=0";
			} else // 아이디가 틀릴경우
			{
				msg = "login.jsp?msg=-1";
			}
		}

		else {
			if (check == 1) // 로그인 성공
			{
				// 세션에 현재 아이디 세팅
				session.setAttribute("sessionID", id);
				msg = "adminMain.jsp";
			} else if (check == 0) // 비밀번호가 틀릴경우
			{
				msg = "login.jsp?msg=0";
			} else // 아이디가 틀릴경우
			{
				msg = "login.jsp?msg=-1";
			}
		}

		// sendRedirect(String URL) : 해당 URL로 이동
		// URL뒤에 get방식 처럼 데이터를 전달가능
		response.sendRedirect(msg);
	%>

</body>
</html>