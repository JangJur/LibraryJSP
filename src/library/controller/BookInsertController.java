package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.BookService;
import library.vo.BookVO;

public class BookInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// parameter추출
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String genre = request.getParameter("genre");
		String author = request.getParameter("author");
		String lent_con = request.getParameter("lent_con");
		String reserv = request.getParameter("reserv");

		// 유효성 체크
		if (number.isEmpty() || name.isEmpty() || genre.isEmpty() || author.isEmpty() || lent_con.isEmpty()
				|| reserv.isEmpty()) {

			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/bookInsertOutput.jsp");

			return;
		}

		// VO객체에 데이터 바인딩
		BookVO book = new BookVO();
		book.setNumber(Integer.parseInt(number));
		book.setName(name);
		book.setGenre(genre);
		book.setAuthor(author);
		book.setLent_con(lent_con);
		book.setReserv(reserv);

		// Service 객체의 메소드 호출
		BookService service = BookService.getInstance();
		service.bookInsert(book);

		// Output view 페이지로 이동
		request.setAttribute("name", name);
		HttpUtil.forward(request, response, "/result/bookInsertOutput.jsp");

	}

}
