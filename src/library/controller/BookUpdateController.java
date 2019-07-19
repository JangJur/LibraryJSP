package library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.BookService;
import library.vo.BookVO;

public class BookUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// parameter����
		String num = request.getParameter("book_num");
		String name = request.getParameter("book_name");
		String genre = request.getParameter("book_class");	
		String pub = request.getParameter("book_pub");
		String author = request.getParameter("book_author");
		
		// ��ȿ�� üũ
		if (num.isEmpty() || name.isEmpty() || genre.isEmpty() || pub.isEmpty() || author.isEmpty()) {

			request.setAttribute("error", "���? �׸��� �������� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, "/bookUpdate.jsp");

			return;
		}

		// VO��ü�� ������ ���ε�
		BookVO book = new BookVO();
		book.setNumber(Integer.parseInt(num));
		book.setName(name);
		book.setGenre(genre);
		book.setPub(pub);
		book.setAuthor(author);
		
		//Service ��ü�� �޼ҵ� ȣ��
		BookService service = BookService.getInstance();
		service.bookUpdate(book);
		
		//Output view �������� �̵�
		request.setAttribute("name", name);
		HttpUtil.forward(request, response, "/result/bookUpdateOutput.jsp");

	}

}
