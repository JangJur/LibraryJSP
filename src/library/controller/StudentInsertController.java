package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.StudentService;
import library.vo.StudentVO;

public class StudentInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// parameter����
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String con = request.getParameter("class");

		// ��ȿ�� üũ
		if (id.isEmpty() || pwd.isEmpty() || name.isEmpty() || tel.isEmpty()) {

			request.setAttribute("error", "��� �׸��� �������� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, "/studentInsert.jsp");

			return;
		}

		// VO��ü�� ������ ���ε�
		StudentVO student = new StudentVO();
		student.setId(id);
		student.setPwd(pwd);
		student.setName(name);
		student.setTel(tel);
		student.setCon(con);
		
		//Service ��ü�� �޼ҵ� ȣ��
		StudentService service = StudentService.getInstance();
		service.studentInsert(student);
		
		//Output view �������� �̵�
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/studentInsertOutput.jsp");

	}

}
