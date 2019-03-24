package au.com.nla2.library;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class BooksControllerServlet
 */
@WebServlet("/BooksControllerServlet")
public class BooksControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private BooksDBUtil booksDbUtil;
	
	@Resource(name = "jdbc/web_library_app")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			booksDbUtil = new BooksDBUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			listBooks(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listBooks(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			List<Books> books = booksDbUtil.getBookDetails();
			
			request.setAttribute("BOOKS_LIST", books);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-books.jsp");
			dispatcher.forward(request, response);
		}

}
