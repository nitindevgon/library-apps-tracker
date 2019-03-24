package au.com.nla2.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PatronsDBUtil {
private DataSource dataSource;
	
	public PatronsDBUtil( DataSource paramDataSource) {
		// TODO Auto-generated constructor stub
		dataSource = paramDataSource;
	}
	
	public List<Patrons> getPatronsDetails() throws Exception {
		
		List<Patrons> patrons = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from patrons order by patron_id";

			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				Integer patronid 		= myRs.getInt("patron_id");
				String patronname 		= myRs.getString("name");
				String patronaddress 	= myRs.getString("address");
				String patronemail 		= myRs.getString("email");
				Integer patronBook 		= myRs.getInt("book_id");
				Patrons tempPatrons 	= new Patrons(patronid, patronname, patronaddress, patronemail,patronBook);
				
				patrons.add(tempPatrons);	
			}
			
			return patrons;
		}
		finally {
			closeConnection(myConn, myStmt, myRs);
		}
	}
	
	public List<Books> getPatronsLendDetails(String theBookId) throws Exception {
		
		
		List<Books> books = new ArrayList<>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			int bookId = Integer.parseInt(theBookId);
			
			myConn = dataSource.getConnection();
			
			String sql = " select * from books "
						+ " where book_id=?";

			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, bookId);
			
			
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				int bookid 			= myRs.getInt("book_id");
				String booktitle 	= myRs.getString("book_title");
				String bookauthor 	= myRs.getString("book_author");
				String bookisbn 	= myRs.getString("book_isbn");
				
				Books tempBooks = new Books(bookid, booktitle, bookauthor, bookisbn);
				System.out.println("bookid " +bookid);
				
				
				books.add(tempBooks);
				
				System.out.println("books.size() " +books.size());
				
				System.out.println("books.get() " + books.get(0));
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
