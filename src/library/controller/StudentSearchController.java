package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.StudentService;
import library.vo.StudentVO;

public class StudentSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// parameter����
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		
		String path = null;
		if (job.equals("search"))
			path = "/studentSearch.jsp";
		else if (job.equals("update"))
			path = "/studentUpdate.jsp";
		else if (job.equals("delete"))
			path = "/studentDelete.jsp";

		// ��ȿ�� üũ
		if (id.isEmpty()) {

			request.setAttribute("error", "ID�� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, "/studentInsert.jsp");

			return;
		}

		// Service ��ü�� �޼ҵ� ȣ��
		StudentService service = StudentService.getInstance();
		StudentVO student = service.studentSearch(id);

		// Output view �������� �̵�
		if (student == null)
			request.setAttribute("result", "�˻��� ������ �����ϴ�!");
		request.setAttribute("student", student);

		if (job.equals("search"))
			path = "/result/studentSearchOutput.jsp";
		HttpUtil.forward(request, response, path);

	}

}
