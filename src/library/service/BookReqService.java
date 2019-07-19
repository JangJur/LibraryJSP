package library.service;

import java.util.ArrayList;

import library.dao.BookDAO;
import library.dao.BookReqDAO;
import library.vo.BookReqVO;
import library.vo.BookVO;

public class BookReqService {
	
	private static BookReqService service = new BookReqService();
	public BookReqDAO dao = BookReqDAO.getInstance();

	private BookReqService() {

	}

	public static BookReqService getInstance() {
		
		return service;
	}

	public void bookreqInsert(BookReqVO member) {
		dao.bookReqInsert(member);
	}
	
	public String bookreqcount() {
		return dao.bookReqCount();
	}
	public void bookreqdelete(String id) {
		dao.bookReqdelete(id);
	}
	public ArrayList<BookReqVO> reqList() {
		ArrayList<BookReqVO> list = dao.reqList();
		return list;
	}
	public ArrayList<BookReqVO> reqList2(String id) {
		ArrayList<BookReqVO> list = dao.reqList2(id);
		return list;
	}

}
