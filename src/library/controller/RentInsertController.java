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
import library.vo.RentVO;
import library.vo.RentbookVO;

public class RentInsertController implements Controller {
	SimpleDateFormat year, month, day;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String rent_num = request.getParameter("rent_num");
		RentService service = RentService.getInstance();
		RentBookService service2 = RentBookService.getInstance();
		BookService service3 = BookService.getInstance();
		int count = service.rentCount();
		System.out.println(count);
		int book_num = Integer.parseInt(request.getParameter("book_num"));
		System.out.println(book_num);
		String stu_id = request.getParameter("id");
		System.out.println(stu_id);
		String rent_num = "D" + stu_id + String.valueOf(count+1);//카운트한 값이 들어가야한다.
		String rent_year, rent_month, rent_day;
		String rent_date, ret_date;
		Calendar cal = Calendar.getInstance();
		String con = null;
		year = new SimpleDateFormat("yyyy");
		month = new SimpleDateFormat("MM");
		day = new SimpleDateFormat("dd");
		
		rent_year = year.format(cal.getTime());
		rent_month = month.format(cal.getTime());
		rent_day = day.format(cal.getTime());
		rent_date = rent_year + rent_month + rent_day;
		
		
		RentVO rent = new RentVO();
		rent.setRent_num(rent_num);
		rent.setBook_num(book_num);
		rent.setStu_id(stu_id);
		rent.setRent_date(rent_date);
		
		service.rentInsert(rent);
		int ret_day = Integer.parseInt(rent_day)+14;
		int ret_month = Integer.parseInt(rent_month);
		if(Integer.parseInt(rent_month) == 1 || Integer.parseInt(rent_month) == 3 || Integer.parseInt(rent_month) == 5 || Integer.parseInt(rent_month) == 7 ||
				Integer.parseInt(rent_month) == 8 || Integer.parseInt(rent_month) == 10 || Integer.parseInt(rent_month) == 12) {
			if(ret_day > 31) {
				ret_day -= 31;
				ret_month +=1;
			}
		}else if(Integer.parseInt(rent_month) == 2) {
			if(ret_day > 28) {
				ret_day -= 28;
				ret_month +=1;
			}
		}else {
			ret_day -= 30;
			ret_month +=1;
		}
		ret_date = rent_year + String.valueOf(ret_month) + String.valueOf(ret_day);
		con = service3.bookrentcon(book_num);
		
		RentbookVO book = new RentbookVO();
		book.setRent_num(rent_num);
		book.setBook_num(book_num);
		book.setRet_date(ret_date);
		book.setRet_con("X");

		
		if(con.equals("O")) {
			HttpUtil.forward(request, response, "/result/Fail2.jsp");
		}else {
			service.rentInsert(rent);
			service2.RentbookInsert(book);
			service3.bookUpdaterent(book_num);
			HttpUtil.forward(request, response, "/result/RentInsertOutput.jsp");
		}
		
	}

}
