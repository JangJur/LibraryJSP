package library.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {

		charset = config.getInitParameter("charset");

		list = new HashMap<String, Controller>();

		list.put("/studentInsert.do", new StudentInsertController());
		list.put("/studentSearch.do", new StudentSearchController());
		list.put("/studentUpdate.do", new StudentUpdateController());
		list.put("/studentDelete.do", new StudentDeleteController());
		list.put("/studentList.do", new StudnetListController());
		
		list.put("/bookInsert.do", new BookRequestApplyController());
		list.put("/bookSearch.do", new BookSearchController());
		list.put("/bookUpdate.do", new BookUpdateController());
		list.put("/bookDelete.do", new BookDeleteController());
		list.put("/bookList.do", new BookListController());
		list.put("/rentall.do", new RentListController());
		list.put("/BookSearch.do", new BookSearchController());
		list.put("/BookRequest.do", new BookRequestController());
		list.put("/RequestList.do", new ReqListController());
		list.put("/RentInsert.do", new RentInsertController());
		list.put("/ReserveInsert.do", new ReserveInsertController());
		list.put("/reserveSearchstu.do", new ReserveListController());
		list.put("/reservedelete.do", new ReservedeleteController());
		list.put("/rentstuall.do", new RentstuListController());
		list.put("/return.do", new RentreturnController());
	}	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}

}
