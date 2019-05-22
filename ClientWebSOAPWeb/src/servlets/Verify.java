package servlets;

import java.io.IOException;
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
 * Servlet implementation class Verify
 */
@WebServlet({ "/Verify", "/verify_servlet" })
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Verify() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		try {

			String pk = (String) request.getParameter("pk");

			ServeiWebServiceLocator service = new ServeiWebServiceLocator();
			ServeiWeb port;
			port = service.getServeiWebPort();

			sessio = request.getSession(true);

			if (port.getVerified(pk)) {
				sessio.setAttribute("mssg_resultat", "El local indicat ja ha esset verificat amb anterioritat");
			} else {

				if (port.verifyLocal(pk)) {
					sessio.setAttribute("mssg_resultat", "El local indicat ha estat verificat correctament");
				} else {
					sessio.setAttribute("mssg_resultat", "El local indicat no ha pogut ser verificat correctament");
				}
			}

			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/verify_out");
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
