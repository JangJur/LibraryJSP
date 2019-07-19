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
import library.service.StudentService;
import library.vo.RentVO;

public class RentreturnController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stu_id = request.getParameter("id");
		String id = request.getParameter("stu_id");
		String retur = request.getParameter("return");
		String month_s, day_s;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		month_s = month.format(cal.getTime());
		day_s = day.format(cal.getTime());
		String retu_day = retur.substring(4, 5);
		String retu_month = retur.substring(2, 3);
		String retur_day = retur.substring(2);
		int term, charge, m_term, days=0;
		m_term = Integer.parseInt(month_s)-Integer.parseInt(retu_month);
		term = Integer.parseInt(retu_day)-Integer.parseInt(day_s);
		
		if(m_term == 1) {
			if(Integer.parseInt(month_s)==1||Integer.parseInt(month_s)==3||Integer.parseInt(month_s)==5||Integer.parseInt(month_s)==7||Integer.parseInt(month_s)==8||Integer.parseInt(month_s)==10||Integer.parseInt(month_s)==12) {
				if(term <0) {
					charge = (31-term)*300;
					days = 31-term;
				}else {
					charge = 300*(31+term);
					days = 31+term;
				}
			}else if(Integer.parseInt(month_s)==2) {
				if(term <0) {
					charge = (28-term)*300;
					days = 28-term;
				}else {
					charge = 300*(28+term);
					days = 28+term;
				}
			}else {
				if(term <0) {
					charge = (30-term)*300;
					days = 30-term;
				}else {
					charge = 300*(30+term);
					days = 30+term;
				}
			}
		}else {
			if(term<0) {
				charge = 0;
			}else {
				charge = 300*term;
			}
		}
		StudentService service4 = StudentService.getInstance();
		int count = service4.count(id);
		if(days >=60) {
			service4.studentcatch(id, count);
		}else {
			service4.studentcount(id, count);
		}
		
		RentBookService service2 = RentBookService.getInstance();
		BookService service3 = BookService.getInstance();
		int booknum = service2.rentbooknum(stu_id);
		
		System.out.println(booknum);
		service2.rentbookreturn(stu_id);
		service3.bookUpdateret(booknum);
		
		
		System.out.println(charge);
		request.setAttribute("count", charge);
		HttpUtil.forward(request, response, "/result/ReturnOutput.jsp");
	}

}
