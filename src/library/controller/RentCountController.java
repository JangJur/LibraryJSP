package library.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.service.RentService;
import library.vo.RentVO;

public class RentCountController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stu_id = request.getParameter("stu_id");
		
		RentVO rent = new RentVO();
		RentService service = RentService.getInstance();
		int count = service.rentCount();
		
		request.setAttribute("count", count);
		//HttpUtil.forward(request, response, "/result/RentInsertOutput.jsp");;
	}

}
