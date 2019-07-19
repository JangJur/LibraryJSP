package library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.BookReqService;
import library.service.BookService;
import library.vo.BookReqVO;
import library.vo.BookVO;

public class ReqListController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookReqService service = BookReqService.getInstance();
		ArrayList<BookReqVO> list = service.reqList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/reqListOutput.jsp");

	}
}
