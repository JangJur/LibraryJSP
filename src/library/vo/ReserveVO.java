package library.vo;

public class ReserveVO {
	String stu_id;
	int book_num;
	String Reserve_date;
	
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getReserve_date() {
		return Reserve_date;
	}
	public void setReserve_date(String reserve_date) {
		Reserve_date = reserve_date;
	}
	
}
