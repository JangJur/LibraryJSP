package library.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.BookService;
import library.service.RentBookService;
import library.service.RentService;
import library.service.ReserveService;
import library.vo.RentVO;
import library.vo.RentbookVO;
import library.vo.ReserveVO;

public class ReservedeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String rent_num = request.getParameter("rent_num");
		
		String book_num = request.getParameter("booknum");
		int num = Integer.parseInt(book_num);
		ReserveService service = ReserveService.getInstance();
		BookService service2 = BookService.getInstance();
		service.reservedelete(num);
		service2.bookUpdatesuccess(num);
		HttpUtil.forward(request, response, "/result/ReservedeleteOutput.jsp");
		
	}

}
