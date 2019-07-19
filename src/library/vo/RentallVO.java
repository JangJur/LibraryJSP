package library.vo;

public class RentallVO {
	String book_name;
	String stu_name;
	String book_sort;
	String stu_id;
	String tel;
	String rent_date;
	String ret_date;
	String ovdcnt;
	String rent_id;
	
	public String getRent_id() {
		return rent_id;
	}
	public void setRent_id(String rent_id) {
		this.rent_id = rent_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_sort() {
		return book_sort;
	}
	public void setBook_sort(String book_sort) {
		this.book_sort = book_sort;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRent_date() {
		return rent_date;
	}
	public void setRent_date(String rent_date) {
		this.rent_date = rent_date;
	}
	public String getRet_date() {
		return ret_date;
	}
	public void setRet_date(String ret_date) {
		this.ret_date = ret_date;
	}
	
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
}
