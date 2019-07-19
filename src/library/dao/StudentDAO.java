package library.dao;

import java.sql.*;
import java.util.*;

import com.sun.org.apache.regexp.internal.RE;

import library.vo.StudentVO;

public class StudentDAO {

	private static StudentDAO dao = new StudentDAO();

	private StudentDAO() {

	}

	public static StudentDAO getInstance() {
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

	public void studentInsert(StudentVO student) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("insert into student values(?,?,?,?,0,'O',5,?)");
			pst.setString(1, student.getId());
			pst.setString(2, student.getName());
			pst.setString(3, student.getPwd());
			pst.setString(4, student.getTel());
			pst.setString(5, student.getCon());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}

	public StudentVO studentSearch(String id) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		StudentVO student = null;

		try {
			conn = connect();
			pst = conn.prepareStatement("select * from student where stu_id=?");
			pst.setString(1, id);

			rs = pst.executeQuery();

			if (rs.next()) {

				student = new StudentVO();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setPwd(rs.getString(3));
				student.setTel(rs.getString(4));
				student.setOvd_cnt(rs.getInt(5));
				student.setLen_con(rs.getString(6));
				student.setLen_pos(rs.getInt(7));
				student.setCon(rs.getString(8));

			}

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return student;
	}

	public void studentUpdate(StudentVO student) {

		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = connect();
			pst = conn.prepareStatement(
					"update student set stu_name=?, stu_pwd=?, stu_tel=?, stu_ovd_cnt=?, stu_len_con=?, stu_len_pos=?, stu_con=? where stu_id=?");
			pst.setString(1, student.getName());
			pst.setString(2, student.getPwd());
			pst.setString(3, student.getTel());
			pst.setInt(4, student.getOvd_cnt());
			pst.setString(5, student.getLen_con());
			pst.setInt(6, student.getLen_pos());
			pst.setString(7, student.getCon());
			pst.setString(8, student.getId());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}

	public void studentDelete(String id) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("delete from student where id=?");
			pst.setString(1, id);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}

	public int count(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count=0;
		try {

			conn = connect();
			pst = conn.prepareStatement("select stu_ovd_cnt from student where stu_id = ?");
			pst.setString(1, id);
			pst.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}
		return count;
	}
	
	public void studentcatch(String id, int count) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("update student set stu_ovd_cnt=?, stu_len_con=? where stu_id=?");
			
			pst.setInt(1, count+1);
			pst.setString(2, "X");
			pst.setString(3, id);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public void studentcount(String id, int count) {
		Connection conn = null;
		PreparedStatement pst = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("update student set stu_ovd_cnt=? where stu_id=?");
			
			pst.setInt(1, count+1);
			pst.setString(2, id);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst);
		}

	}
	public ArrayList<StudentVO> studentList() {
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		StudentVO student = null;

		try {

			conn = connect();
			pst = conn.prepareStatement("select * from student");
			rs = pst.executeQuery();

			while (rs.next()) {

				student = new StudentVO();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setPwd(rs.getString(3));
				student.setTel(rs.getString(4));
				student.setOvd_cnt(rs.getInt(5));
				student.setLen_con(rs.getString(6));
				student.setLen_pos(rs.getInt(7));
				student.setCon(rs.getString(8));
				list.add(student);

			}

		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pst, rs);
		}

		return list;
	}

	public int loginCheck(String id, String pw, boolean check) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
		int x = -1;

		try {
			// 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
			StringBuffer query = new StringBuffer();
			if (check == false)
				query.append("select stu_pwd from student where stu_id=?");
			else
				query.append("select man_pwd from manager where man_id=?");

			conn = connect();
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
			{
				if (check == false)
					dbPW = rs.getString("stu_pwd"); // 비번을 변수에 넣는다.
				else
					dbPW = rs.getString("man_pwd");

				if (dbPW.equals(pw))
					x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
				else
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패

			} else {
				x = -1; // 해당 아이디가 없을 경우
			}

			return x;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
