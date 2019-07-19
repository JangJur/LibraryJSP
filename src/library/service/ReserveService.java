package library.service;

import java.util.ArrayList;

import library.dao.RentDAO;
import library.dao.ReserveDAO;
import library.vo.RentVO;
import library.vo.ReserveVO;
import library.vo.ReserveallVO;

public class ReserveService {
	
	private static ReserveService service = new ReserveService();
	public ReserveDAO dao = ReserveDAO.getInstance();

	private ReserveService() {

	}

	public static ReserveService getInstance() {
		
		return service;
	}

	public void reserveInsert(ReserveVO member) {
		dao.ReserveInsert(member);
	}
	public void reservedelete(int num) {
		dao.reserveDelete(num);
	}
	public ArrayList<ReserveallVO> reserveList(String id) {
		ArrayList<ReserveallVO> list = dao.ReserveList(id);
		return list;
	}

}
