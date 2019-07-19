package library.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import library.service.RentAllService;
import library.service.StudentService;
import library.vo.RentallVO;
import library.vo.StudentVO;

public class RentstuListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RentAllService service = RentAllService.getInstance();
		String stu_id = request.getParameter("id");
		ArrayList<RentallVO> list = service.rentSearchwho(stu_id);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/rentstuListOutput.jsp");

	}

}
