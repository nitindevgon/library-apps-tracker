package au.com.nla2.library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BooksDBUtil {
	private DataSource dataSource;
	
	public BooksDBUtil( DataSource paramDataSource) {
		// TODO Auto-generated constructor stub
		dataSource = paramDataSource;
	}
	
	public List<Books> getBookDetails() throws Exception {
		
		List<Books> books = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from books order by book_id";

			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				int bookid 			= myRs.getInt("book_id");
				String booktitle 	= myRs.getString("book_title");
				String bookauthor 	= myRs.getString("book_author");
				String bookisbn 	= myRs.getString("book_isbn");
				
				Books tempBooks = new Books(bookid, booktitle, bookauthor, bookisbn);
				
				books.add(tempBooks);	
			}
			
			return books;
		}
		finally {
			closeConnection(myConn, myStmt, myRs);
		}
	}
	
	private void closeConnection(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
