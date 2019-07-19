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
		
		// parameter����
		BookReqService service = BookReqService.getInstance();
		
		String name = request.getParameter("name");
		String pub = request.getParameter("pub");
		String author = request.getParameter("author");
		String classs = request.getParameter("class");
		String stu_id = request.getParameter("stu_id");
		String num = service.bookreqcount();
		
		// ��ȿ�� üũ
		if (name.isEmpty() || pub.isEmpty() || author.isEmpty()) {

			request.setAttribute("error", "��� �׸��� �������� �Է����ֽñ� �ٶ��ϴ�!");
			HttpUtil.forward(request, response, "/RequestInsertOutput.jsp");
			
			return;
		}
		System.out.println(num);
		// VO��ü�� ������ ���ε�
		BookReqVO book = new BookReqVO();
		book.setNum(Integer.parseInt(num)+1);
		book.setBook_name(name);
		book.setBook_pub(pub);
		book.setBook_auth(author);
		book.setBook_class(classs);
		book.setStu_id(stu_id);

		// Service ��ü�� �޼ҵ� ȣ��
		
		service.bookreqInsert(book);

		// Output view �������� �̵�
		request.setAttribute("name", name);
		HttpUtil.forward(request, response, "/result/RequestInsertOutput.jsp");

	}

}
