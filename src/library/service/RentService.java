package library.service;

import java.util.ArrayList;

import library.dao.RentDAO;
import library.vo.RentVO;

public class RentService {
	
	private static RentService service = new RentService();
	public RentDAO dao = RentDAO.getInstance();

	private RentService() {

	}

	public static RentService getInstance() {
		
		return service;
	}

	public void rentInsert(RentVO member) {
		dao.rentInsert(member);
	}
	
	public int rentCount() {
		return dao.rentCount();
	}
	

}
