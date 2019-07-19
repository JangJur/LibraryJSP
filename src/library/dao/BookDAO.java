package library.dao;

import java.sql.*;
import java.util.ArrayList;

import library.vo.BookVO;
import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class BookDAO {

	private static BookDAO dao = new BookDAO();

	private BookDAO() {

	}

	public static BookDAO getInstance() {
		return dao;
	}

	public Connection connect() {

		Connection conn = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:JHDB", "library", "qkr95091154");

		} catch (Exception e) {
			System.out.println("forward ?���? : " + e);
		}

		return conn;
	}

	public void close(Connection conn, PreparedStatement pst, ResultSet rs) {

		if (rs != null) {
			try {

			} catch (Exception e) {
				System.out.println("?���? 발생 : " + e);
			}
		}

		close(conn, pst);
	}

	public void close(Connection conn, PreparedStatement pst) {

		if (pst != null) {
			try {

				pst.close();

			} catch (Exception e) {
				System.out.println("?���? 발생 : " + e);
			}
		}

		if (conn != null) {
			try {

				conn.close();

			} catch (Exception e) {
				System.out.println("?���? 발생 : " + e);
			}
		}

	}

	public void bookInsert(BookVO book) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
			pst.setInt(1, book.getNumber());
			pst.setString(2, book.getName());
			pst.setString(3, book.getGenre());
			pst.setString(4, book.getPub());
			pst.setString(5, book.getAuthor());
			pst.setString(6, book.getLent_con());
			pst.setString(7, book.getReserv());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}

	public BookVO bookSearch(String name) {

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
			System.out.println("?���? 발생 : " + e);
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
			pst = conn.prepareStatement(
					"update book set book_name=?, book_class=?, book_pub=?, book_author=? where book_num=?");
			
			// �����ؾߴ�
			pst.setString(1, book.getName());
			pst.setString(2, book.getGenre());
			pst.setString(3, book.getPub());
			pst.setString(4, book.getAuthor());
			pst.setInt(5, book.getNumber());
			
			
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public void bookUpdaterent(int num) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = connect();
			pst = conn.prepareStatement(
					"update book set book_lent_con=? where book_num=?");
			
			// �����ؾߴ�
			pst.setString(1, "O");
			pst.setInt(2, num);
			
			
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public void bookUpdateret(int num) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = connect();
			pst = conn.prepareStatement(
					"update book set book_lent_con=? where book_num=?");
			
			// �����ؾߴ�
			pst.setString(1, "X");
			pst.setInt(2, num);
			
			
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public void bookUpdateres(int book_num) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = connect();
			pst = conn.prepareStatement(
					"update book set book_reserv=? where book_num=?");
			
			// �����ؾߴ�
			pst.setString(1, "O");
			pst.setInt(2, book_num);
			
			
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public void bookUpdatesuccess(int num) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = connect();
			pst = conn.prepareStatement(
					"update book set book_reserv=? where book_num=?");
			
			// �����ؾߴ�
			pst.setString(1, "X");
			pst.setInt(2, num);
			
			
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
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
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public String bookreserve(int num) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String con = null;
		try {

			conn = connect();
			pst = conn.prepareStatement("select book_reserv from book where book_num = ?");
			pst.setInt(1, num);
			rs = pst.executeQuery();
			rs.next();
			con = rs.getString(1);
			
		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}
		return con;
	}
	
	public String bookrentcon(int num) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String con = null;
		try {

			conn = connect();
			pst = conn.prepareStatement("select book_lent_con from book where book_num = ?");
			pst.setInt(1, num);
			rs = pst.executeQuery();
			rs.next();
			con = rs.getString(1);
			
		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}
		return con;
	}
	public String bookCount(String classs) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String num = null;
		try {

			conn = connect();
			pst = conn.prepareStatement("select count(*) from book where book_class= ?");
			pst.setString(1, classs);
			rs = pst.executeQuery();
			rs.next();
			num = rs.getString(1);
			
		} catch (Exception e) {
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst);
		}
		return num;
	}
	public ArrayList<BookVO> bookList() {
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
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return list;
	}
	
	public ArrayList<BookVO> bookListkey(String key, String word) {
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
			System.out.println("?���? 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return list;
	}
}
