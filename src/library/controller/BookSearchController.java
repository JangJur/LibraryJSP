package library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.BookService;
import library.service.StudentService;
import library.vo.BookVO;
import library.vo.StudentVO;

public class BookSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key = request.getParameter("keyField");
		String Word = request.getParameter("keyWord");
		String job = request.getParameter("job");
		
		if (job == null)
			job = "search";
		
		BookService service = BookService.getInstance();
		BookVO book = service.bookSearch(Word);
		request.setAttribute("book", book);
		String path = null;
		if (job.equals("search")) {
			path = "/result/studentBookOutput.jsp";
			ArrayList<BookVO> list = service.bookList2(key, Word);
			request.setAttribute("list", list);
		}
		else if (job.equals("update")) {
			path = "/bookUpdate.jsp";
			
		}
		HttpUtil.forward(request, response, path);
	}

}
