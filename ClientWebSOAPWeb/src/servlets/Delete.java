package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import serveiWebSOAP.ServeiWeb;
import serveiWebSOAP.ServeiWebServiceLocator;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doFer(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doFer(request, response);
	}

	private void doFer(HttpServletRequest request, HttpServletResponse response) {

		HttpSession sessio;
		Connection connection = null;

		try {

			String pk = (String) request.getParameter("pk");

			ServeiWebServiceLocator service = new ServeiWebServiceLocator();
			ServeiWeb port;
			port = service.getServeiWebPort();

			sessio = request.getSession(true);

				if (port.removeLocal(pk)) {
					sessio.setAttribute("mssg_resultat", "El local indicat ha estat donat de baixa correctament");
				} else {
					sessio.setAttribute("mssg_resultat", "El local indicat no ha pogut ser donat de baixa correctament");
				}

			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/delete_out");
			rd.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}


}
