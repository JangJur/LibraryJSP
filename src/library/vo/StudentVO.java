package library.vo;

public class StudentVO {

	private String id;
	private String name;
	private String pwd;
	private String tel;
	private int ovd_cnt;
	private String len_con;
	private int len_pos;
	private String con;
	
	public int getOvd_cnt() {
		return ovd_cnt;
	}
	public void setOvd_cnt(int ovd_cnt) {
		this.ovd_cnt = ovd_cnt;
	}
	public String getLen_con() {
		return len_con;
	}
	public void setLen_con(String len_con) {
		this.len_con = len_con;
	}
	public int getLen_pos() {
		return len_pos;
	}
	public void setLen_pos(int len_pos) {
		this.len_pos = len_pos;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
