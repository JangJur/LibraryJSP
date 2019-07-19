package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.BookReqDAO;
import library.service.BookReqService;
import library.service.BookService;
import library.vo.BookReqVO;
import library.vo.BookVO;

public class BookRequestController implements Controller {
	BookReqDAO req = null;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// parameter추출
		BookReqService service = BookReqService.getInstance();
		
		String name = request.getParameter("name");
		String pub = request.getParameter("pub");
		String author = request.getParameter("author");
		String classs = request.getParameter("class");
		String stu_id = request.getParameter("stu_id");
		String num = service.bookreqcount();
		
		// 유효성 체크
		if (name.isEmpty() || pub.isEmpty() || author.isEmpty()) {

			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/RequestInsertOutput.jsp");
			
			return;
		}
		System.out.println(num);
		// VO객체에 데이터 바인딩
		BookReqVO book = new BookReqVO();
		book.setNum(Integer.parseInt(num)+1);
		book.setBook_name(name);
		book.setBook_pub(pub);
		book.setBook_auth(author);
		book.setBook_class(classs);
		book.setStu_id(stu_id);

		// Service 객체의 메소드 호출
		
		service.bookreqInsert(book);

		// Output view 페이지로 이동
		request.setAttribute("name", name);
		HttpUtil.forward(request, response, "/result/RequestInsertOutput.jsp");

	}

}
