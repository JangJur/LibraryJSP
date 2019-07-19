package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.vo.BookVO;
import library.vo.RentVO;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class RentDAO {

	private static RentDAO dao = new RentDAO();

	private RentDAO() {

	}

	public static RentDAO getInstance() {
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

	public void rentInsert(RentVO rent) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("insert into rent values(?,?,?,?)");
			pst.setString(1, rent.getStu_id());
			pst.setInt(2, rent.getBook_num());
			pst.setString(3, rent.getRent_num());
			pst.setString(4, rent.getRent_date());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public int rentCount() {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int total = 0;
		try {

			conn = connect();
			pst = conn.prepareStatement("select count(*) from rent");
			rs = pst.executeQuery();
			rs.next();
			total = rs.getInt("count");
			System.out.println(total);
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}
		return total;

	}
	
	
	/*public BookVO bookSearch(String name) {

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

	public void bookUpdate(BookVO book) {

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

	/*public void rentDelete(String name) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("delete from rent where rent_num=?");
			pst.setString(1, name);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}*/
	/*public ArrayList<BookVO> bookList() {
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		BookVO book = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("select * from book");
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
