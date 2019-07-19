package library.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import library.service.StudentService;
import library.vo.StudentVO;

public class StudnetListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentService service = StudentService.getInstance();
		ArrayList<StudentVO> list = service.studentList();
		
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat date = new SimpleDateFormat("dd");
		String rent_date = date.format(cal.getTime());
		System.out.println(rent_date);
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/studentListOutput.jsp");

	}

}
