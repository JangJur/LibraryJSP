package library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.BookService;
import library.vo.BookVO;

public class BookListController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService service = BookService.getInstance();
		ArrayList<BookVO> list = service.bookList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/adminbookListOutput.jsp");

	}
}
