package au.com.nla2.library;

public class Books {
	private Integer bookId;
	private String 	bookTitle;
	private String 	bookAuthor;
	private String 	bookISBN;
	
	public Books(Integer bookId, String bookTitle, String bookAuthor, String bookISBN) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookISBN = bookISBN;
	}

	public Books(String bookTitle, String bookAuthor, String bookISBN) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookISBN = bookISBN;
	}
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookISBN="
				+ bookISBN + "]";
	}
	
	
}
