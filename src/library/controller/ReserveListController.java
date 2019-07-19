package library.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import library.service.RentAllService;
import library.service.ReserveService;
import library.service.StudentService;
import library.vo.RentallVO;
import library.vo.ReserveVO;
import library.vo.ReserveallVO;
import library.vo.StudentVO;

public class ReserveListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReserveService service = ReserveService.getInstance();
		String id = request.getParameter("id");
		ArrayList<ReserveallVO> list = service.reserveList(id);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/ReserveListOutput.jsp");

	}

}
