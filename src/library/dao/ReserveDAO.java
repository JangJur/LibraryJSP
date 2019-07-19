package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.vo.BookVO;
import library.vo.RentVO;
import library.vo.RentbookVO;
import library.vo.ReserveVO;
import library.vo.ReserveallVO;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class ReserveDAO {

	private static ReserveDAO dao = new ReserveDAO();

	private ReserveDAO() {

	}

	public static ReserveDAO getInstance() {
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

	public void ReserveInsert(ReserveVO reserve) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("insert into reserve values(?,?,?)");
			pst.setString(1, reserve.getStu_id());
			pst.setInt(2, reserve.getBook_num());
			pst.setString(3, reserve.getReserve_date());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

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
*/
	public void reserveDelete(int num) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("delete from reserve where book_num=?");
			pst.setInt(1, num);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public ArrayList<ReserveallVO> ReserveList(String stu_id) {
		ArrayList<ReserveallVO> list = new ArrayList<ReserveallVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ReserveallVO all = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("select reserve.stu_id, student.stu_name, reserve.book_num, book.book_name, reserve.reserve_date from student, reserve, book where student.stu_id = reserve.stu_id and book.book_num = reserve.book_num and reserve.stu_id = ?");
			pst.setString(1, stu_id);
			rs = pst.executeQuery();
			
			while (rs.next()) {

				all = new ReserveallVO();
				all.setStu_id(rs.getString(1));
				all.setStu_name(rs.getString(2));
				all.setBook_num(rs.getInt(3));
				all.setBook_name(rs.getString(4));
				all.setReserve_date(rs.getString(5));
				list.add(all);

			}

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return list;
	}

}
