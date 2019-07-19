package library.vo;

public class BookVO {

	private int number;
	private String name;
	private String genre;
	private String pub;
	private String author;
	private String lent_con;
	private String reserv;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLent_con() {
		return lent_con;
	}

	public void setLent_con(String lent_con) {
		this.lent_con = lent_con;
	}

	public String getReserv() {
		return reserv;
	}

	public void setReserv(String reserv) {
		this.reserv = reserv;
	}

}
