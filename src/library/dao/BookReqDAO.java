package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

import library.vo.BookReqVO;
import library.vo.BookVO;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class BookReqDAO {

	private static BookReqDAO dao = new BookReqDAO();

	private BookReqDAO() {

	}

	public static BookReqDAO getInstance() {
		return dao;
	}

	public Connection connect() {

		Connection conn = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:JHDB", "library", "qkr95091154");

		} catch (Exception e) {
			System.out.println("forward 오류 : " + e);
		}

		return conn;
	}

	public void close(Connection conn, PreparedStatement pst, ResultSet rs) {

		if (rs != null) {
			try {

			} catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}

		close(conn, pst);
	}

	public void close(Connection conn, PreparedStatement pst) {

		if (pst != null) {
			try {

				pst.close();

			} catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}

		if (conn != null) {
			try {

				conn.close();

			} catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}

	}

	public void bookReqInsert(BookReqVO req) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("insert into request values(?,?,?,?,?,?)");
			pst.setInt(1, req.getNum());
			pst.setString(2, req.getBook_name());
			pst.setString(3, req.getBook_pub());
			pst.setString(4, req.getBook_auth());
			pst.setString(5, req.getBook_class());
			pst.setString(6, req.getStu_id());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}

	
	public void bookReqdelete(String num) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("delete from request where req_num = ?");
			pst.setString(1, num);
			
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			System.out.println("삭제됨");
			close(conn, pst);
		}

	}
	public String bookReqCount() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String num = null;
		try {

			conn = connect();
			pst = conn.prepareStatement("select count(*) from request");
			rs = pst.executeQuery();
			rs.next();
			num = rs.getString(1);
			
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}
		return num;
	}
	
	
	/*public BookVO bookReqSearch(String name) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		BookVO book = null;

		try {
			conn = connect();
			pst = conn.prepareStatement("select * from book where book_name=?");
			pst.setString(1, name);

			rs = pst.executeQuery();

			if (rs.next()) {

				book = new BookVO();
				book.setNumber(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setGenre(rs.getString(3));
				book.setPub(rs.getString(4));
				book.setAuthor(rs.getString(5));
				book.setLent_con(rs.getString(6));
				book.setReserv(rs.getString(7));

			}

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return book;
	}

	/*public void bookUpdate(BookVO book) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = connect();
			pst = conn.prepareStatement("update book set book_lent_con=?,book_reserv=? where book_name=?");
			
			// 수정해야댐
			pst.setString(1, book.getLent_con());
			pst.setString(2, book.getReserv());
			pst.setString(3, book.getName());
			
			
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}

	public void bookDelete(String name) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("delete from book where book_name=?");
			pst.setString(1, name);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}*/
	public ArrayList<BookReqVO> reqList() {
		ArrayList<BookReqVO> list = new ArrayList<BookReqVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BookReqVO book = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("select * from request");
			rs = pst.executeQuery();

			while (rs.next()) {

				book = new BookReqVO();
				book.setNum(rs.getInt(1));
				book.setBook_name(rs.getString(2));
				book.setBook_pub(rs.getString(3));
				book.setBook_auth(rs.getString(4));
				book.setBook_class(rs.getString(5));
				book.setStu_id(rs.getString(6));

				
				list.add(book);

			}

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return list;
	}
	
	public ArrayList<BookReqVO> reqList2(String id) {
		ArrayList<BookReqVO> list = new ArrayList<BookReqVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BookReqVO book = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("select * from request where req_num = ?");
			pst.setString(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {

				book = new BookReqVO();
				book.setNum(rs.getInt(1));
				book.setBook_name(rs.getString(2));
				book.setBook_pub(rs.getString(3));
				book.setBook_auth(rs.getString(4));
				book.setBook_class(rs.getString(5));
				book.setStu_id(rs.getString(6));

				
				list.add(book);

			}

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return list;
	}
	/*public ArrayList<BookReqVO> Listkey(String key, String word) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BookVO book = null;
		String sql = null;
		Statement st;
		try {

			conn = connect();
			
			
			if(word!=null&& !word.equals("")) {
				sql = " WHERE "+key.trim()+" LIKE '%"+word.trim()+"%' order by "+key.trim();
				pst = conn.prepareStatement("select * from book" + sql);
			}else {
				sql = "order by book_num";
				pst = conn.prepareStatement("select * from book " + sql);

			}
			
			rs = pst.executeQuery();


			while (rs.next()) {

				book = new BookVO();
				book.setNumber(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setGenre(rs.getString(3));
				book.setPub(rs.getString(4));
				book.setAuthor(rs.getString(5));
				book.setLent_con(rs.getString(6));
				book.setReserv(rs.getString(7));
				
				list.add(book);

			}

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return list;
	}*/
}
