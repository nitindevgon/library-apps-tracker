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
 * Servlet implementation class PatronsControllerServlet
 */
@WebServlet("/PatronsControllerServlet")
public class PatronsControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private PatronsDBUtil patronsDbUtil;
	
	@Resource(name = "jdbc/web_library_app")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			patronsDbUtil = new PatronsDBUtil(dataSource);
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
		
		/*try {
			listPatrons(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new ServletException(e);
		}*/
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listPatrons(request, response);
				break;
				
			case "LOAD":
				loadPatrons(request, response);
				break;
				
			default:
				listPatrons(request, response);
			}
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listPatrons(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			List<Patrons> patrons = patronsDbUtil.getPatronsDetails();
			
			request.setAttribute("PATRONS_LIST", patrons);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-patrons.jsp");
			dispatcher.forward(request, response);
		}

	private void loadPatrons(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			
			
			
			String theBookID = request.getParameter("patronBook");
			
			System.out.println("patronBook"+theBookID);
			
			List<Books> theBook = patronsDbUtil.getPatronsLendDetails(theBookID);
			
			request.setAttribute("PATRONS_LOAD", theBook);
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/lend-book-form.jsp");
			
			dispatcher.forward(request, response);
		}
	
}
