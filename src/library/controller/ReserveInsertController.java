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

public class ReserveInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String rent_num = request.getParameter("rent_num");
		Calendar cal = Calendar.getInstance();
		String stu_id = request.getParameter("id");
		BookService service2 = BookService.getInstance();

		System.out.println(stu_id);
		String book_num_s = request.getParameter("book_num");
		int book_num = Integer.parseInt(book_num_s);
		String con = service2.bookreserve(book_num);
		if(con.equals("O")) {
			HttpUtil.forward(request, response, "/result/Fail.jsp");
		}else {
			String reserve_date = null;
			SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
			reserve_date = date.format(cal.getTime());
			ReserveVO book = new ReserveVO();
			book.setStu_id(stu_id);
			book.setBook_num(book_num);
			book.setReserve_date(reserve_date);
			
			ReserveService service = ReserveService.getInstance();
			service.reserveInsert(book);
			service2.bookUpdateres(book_num);
			
			HttpUtil.forward(request, response, "/result/ReserveInsertOutput.jsp");
		}
		
	}

}
