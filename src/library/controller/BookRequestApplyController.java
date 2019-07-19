package library.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.dao.BookReqDAO;
import library.service.BookReqService;
import library.service.BookService;
import library.vo.BookReqVO;
import library.vo.BookVO;

public class BookRequestApplyController implements Controller {
	BookReqDAO req = null;
	ArrayList<BookReqVO> req2 = null;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// parameter추출
		BookReqService service = BookReqService.getInstance();
		BookService service2 = BookService.getInstance();
		String id = request.getParameter("id");
		req2 = service.reqList2(id);
		String name = req2.get(0).getBook_name();
		String pub = req2.get(0).getBook_pub();
		String author = req2.get(0).getBook_auth();
		String classs = req2.get(0).getBook_class();
		String stu_id = req2.get(0).getStu_id();
		String classnum = null;
		String num = service2.bookCount(classs);
		
		if(classs.equals("순수과학")) {
			classnum = "400";
		}else if(classs.equals("사회과학")) {
			classnum = "300";
		}else if(classs.equals("기숧과학")) {
			classnum = "500";
		}else if(classs.equals("예술")) {
			classnum = "600";
		}else {
			classnum = "700";
		}
		
		if(Integer.parseInt(num)>0 && Integer.parseInt(num) < 10) {
			num = "0" + (Integer.parseInt(num)+1);
		}else if(Integer.parseInt(num)==0) {
			num = "01";
		}
		int booknum = Integer.parseInt(classnum + num);
		
		System.out.println(booknum);
		// VO객체에 데이터 바인딩
		BookVO book = new BookVO();
		book.setNumber(booknum);
		book.setName(name);
		book.setGenre(classs);
		book.setPub(pub);
		book.setAuthor(author);
		book.setLent_con("X");
		book.setReserv("X");

		// Service 객체의 메소드 호출
		
		service2.bookInsert(book);
		service.bookreqdelete(id);
		// Output view 페이지로 이동
		request.setAttribute("name", book);
		HttpUtil.forward(request, response, "/result/bookInsertOutput.jsp");

	}

}
