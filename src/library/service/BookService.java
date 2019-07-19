package library.service;

import java.util.ArrayList;

import library.dao.BookDAO;
import library.vo.BookVO;

public class BookService {
	
	private static BookService service = new BookService();
	public BookDAO dao = BookDAO.getInstance();

	private BookService() {

	}

	public static BookService getInstance() {
		
		return service;
	}

	public void bookInsert(BookVO member) {
		dao.bookInsert(member);
	}

	public BookVO bookSearch(String id) {
		BookVO member = dao.bookSearch(id);
		return member;
	}

	public void bookUpdate(BookVO member) {
		dao.bookUpdate(member);
	}

	public void bookDelete(String id) {
		dao.bookDelete(id);
	}
	public String bookCount(String id) {
		return dao.bookCount(id);
	}
	public void bookUpdatesuccess(int num) {
		dao.bookUpdatesuccess(num);
	}
	public void bookUpdateres(int book_num) {
		dao.bookUpdateres(book_num);
	}
	public String bookreserve(int num) {
		return dao.bookreserve(num);
	}
	public String bookrentcon(int num) {
		return dao.bookrentcon(num);
	}
	public void bookUpdateret(int num) {
		dao.bookUpdateret(num);
	}
	public void bookUpdaterent(int num) {
		dao.bookUpdaterent(num);
	}
	public ArrayList<BookVO> bookList() {
		ArrayList<BookVO> list = dao.bookList();
		return list;
	}
	public ArrayList<BookVO> bookList2(String key, String word){
		ArrayList<BookVO> list = dao.bookListkey(key, word);
		return list;
	}

}
