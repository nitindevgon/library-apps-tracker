package au.com.nla2.library;

public class Patrons {
	private Integer patronId;
	private String name;
	private String address;
	private String email;
	private Integer patronBook;

	public Integer getPatronBook() {
		return patronBook;
	}

	public void setPatronBook(Integer patronBook) {
		this.patronBook = patronBook;
	}

	public Patrons(Integer patronId, String name, String address, String email, Integer patronBook) {
		this.patronId = patronId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.patronBook = patronBook;
	}

	public Patrons(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public Integer getPatronId() {
		return patronId;
	}

	public void setPatronId(Integer patronId) {
		this.patronId = patronId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patrons [patronId=" + patronId + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", patronBook=" + patronBook + "]";
	}

}
