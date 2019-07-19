package library.service;

import java.util.ArrayList;

import library.dao.RentAllDAO;
import library.dao.StudentDAO;
import library.vo.RentallVO;
import library.vo.StudentVO;

public class RentAllService {

	private static RentAllService service = new RentAllService();
	public RentAllDAO dao = RentAllDAO.getInstance();

	private RentAllService() {

	}

	public static RentAllService getInstance() {
		return service;
	}

	public ArrayList<RentallVO> RentList() {
		ArrayList<RentallVO> list = dao.rentSearch();
		return list;
	}
	public ArrayList<RentallVO> rentSearchwho(String stu_id) {
		ArrayList<RentallVO> list = dao.rentSearchwho(stu_id);
		return list;
	}
}
