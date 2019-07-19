package library.service;

import java.util.ArrayList;

import library.dao.RentBookDAO;
import library.dao.RentDAO;
import library.vo.RentVO;
import library.vo.RentbookVO;

public class RentBookService {
	
	private static RentBookService service = new RentBookService();
	public RentBookDAO dao = RentBookDAO.getInstance();

	private RentBookService() {

	}

	public static RentBookService getInstance() {
		
		return service;
	}

	public void RentbookInsert(RentbookVO member) {
		dao.rentbookInsert(member);
	}
	
	public int rentbookCount(RentbookVO member) {
		return dao.rentbookCount();
	}
	public void rentbookreturn(String num) {
		dao.rentbookret(num);
	}
	public int rentbooknum(String num) {
		return dao.rentbooknum(num);
	}
}
