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

		// parameter추출
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		
		String path = null;
		if (job.equals("search"))
			path = "/studentSearch.jsp";
		else if (job.equals("update"))
			path = "/studentUpdate.jsp";
		else if (job.equals("delete"))
			path = "/studentDelete.jsp";

		// 유효성 체크
		if (id.isEmpty()) {

			request.setAttribute("error", "ID를 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/studentInsert.jsp");

			return;
		}

		// Service 객체의 메소드 호출
		StudentService service = StudentService.getInstance();
		StudentVO student = service.studentSearch(id);

		// Output view 페이지로 이동
		if (student == null)
			request.setAttribute("result", "검색된 정보가 없습니다!");
		request.setAttribute("student", student);

		if (job.equals("search"))
			path = "/result/studentSearchOutput.jsp";
		HttpUtil.forward(request, response, path);

	}

}
