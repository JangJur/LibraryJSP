package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.StudentService;
import library.vo.StudentVO;

public class StudentUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// parameter추출
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");	
		String tel = request.getParameter("tel");
		int ovd_cnt = Integer.parseInt(request.getParameter("ovd_cnt"));
		String len_con = request.getParameter("len_con");
		int len_pos = Integer.parseInt(request.getParameter("len_pos"));
		String con = request.getParameter("con");

		// 유효성 체크
		if (id.isEmpty() || pwd.isEmpty() || name.isEmpty() || tel.isEmpty()) {

			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/studentUpdate.jsp");

			return;
		}

		// VO객체에 데이터 바인딩
		StudentVO student = new StudentVO();
		student.setId(id);
		student.setName(name);
		student.setPwd(pwd);
		student.setTel(tel);
		student.setOvd_cnt(ovd_cnt);
		student.setLen_con(len_con);
		student.setLen_pos(len_pos);
		student.setCon(con);
		
		//Service 객체의 메소드 호출
		StudentService service = StudentService.getInstance();
		service.studentUpdate(student);
		
		//Output view 페이지로 이동
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/studentUpdateOutput.jsp");

	}

}
