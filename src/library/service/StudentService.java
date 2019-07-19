package library.service;

import java.util.ArrayList;

import library.dao.StudentDAO;
import library.vo.StudentVO;

public class StudentService {

	private static StudentService service = new StudentService();
	public StudentDAO dao = StudentDAO.getInstance();

	private StudentService() {

	}

	public static StudentService getInstance() {
		
		return service;
	}

	public void studentInsert(StudentVO student) {
		dao.studentInsert(student);
	}

	public StudentVO studentSearch(String id) {
		StudentVO student = dao.studentSearch(id);
		return student;
	}

	public void studentUpdate(StudentVO student) {
		dao.studentUpdate(student);
	}

	public void studentDelete(String id) {
		dao.studentDelete(id);
	}
	public int count(String id) {
		return dao.count(id);
	}
	public void studentcatch(String id, int count) {
		dao.studentcatch(id, count);
	}
	public void studentcount(String id, int count) {
		dao.studentcount(id, count);
	}
	public ArrayList<StudentVO> studentList() {
		ArrayList<StudentVO> list = dao.studentList();
		return list;
	}

}
