package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.StudentService;

public class StudentDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// parameter ����
		String id = request.getParameter("id");
		
		// Service ��ü�� �޼ҵ� ȣ��
		StudentService service = StudentService.getInstance();
		service.studentDelete(id);
		
		//Output View ������ �̵�
		HttpUtil.forward(request, response, "/result/studentDeleteOutput.jsp");

	}

}
