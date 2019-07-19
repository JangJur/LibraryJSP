package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.StudentService;

public class StudentDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// parameter 추출
		String id = request.getParameter("id");
		
		// Service 객체의 메소드 호출
		StudentService service = StudentService.getInstance();
		service.studentDelete(id);
		
		//Output View 페이지 이동
		HttpUtil.forward(request, response, "/result/studentDeleteOutput.jsp");

	}

}
