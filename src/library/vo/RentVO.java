package library.vo;

public class RentVO {
	String rent_num;
	int book_num;
	String stu_id;
	String rent_date;
	public String getRent_num() {
		return rent_num;
	}
	public void setRent_num(String rent_num) {
		this.rent_num = rent_num;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getRent_date() {
		return rent_date;
	}
	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}
	
	
}
