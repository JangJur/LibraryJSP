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

		// parameter����
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String genre = request.getParameter("genre");
		String author = request.getParameter("author");
		String lent_con = request.getParameter("lent_con");
		String reserv = request.getParameter("reserv");

		// ��ȿ�� üũ
		if (number.isEmpty() || name.isEmpty() || genre.isEmpty() || author.isEmpty() || lent_con.isEmpty()
				|| reserv.isEmpty()) {

			request.setAttribute("error", "��� �׸��� �������� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, "/bookInsertOutput.jsp");

			return;
		}

		// VO��ü�� ������ ���ε�
		BookVO book = new BookVO();
		book.setNumber(Integer.parseInt(number));
		book.setName(name);
		book.setGenre(genre);
		book.setAuthor(author);
		book.setLent_con(lent_con);
		book.setReserv(reserv);

		// Service ��ü�� �޼ҵ� ȣ��
		BookService service = BookService.getInstance();
		service.bookInsert(book);

		// Output view �������� �̵�
		request.setAttribute("name", name);
		HttpUtil.forward(request, response, "/result/bookInsertOutput.jsp");

	}

}
