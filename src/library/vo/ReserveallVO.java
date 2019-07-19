package library.vo;

public class ReserveallVO {
	String stu_id;
	String stu_name;
	int book_num;
	String book_name;
	String Reserve_date;
	
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getReserve_date() {
		return Reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		Reserve_date = reserve_date;
	}
	
	
}
