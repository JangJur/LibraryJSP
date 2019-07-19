package library.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import library.service.RentAllService;
import library.service.StudentService;
import library.vo.RentallVO;
import library.vo.StudentVO;

public class RentListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RentAllService service = RentAllService.getInstance();
		ArrayList<RentallVO> list = service.RentList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/rentListOutput.jsp");

	}

}
