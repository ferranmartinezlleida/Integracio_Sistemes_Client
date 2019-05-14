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

import serveiWebSOAP.*;


/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doFer(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doFer(request, response);
	}
	
	private void doFer(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session;
		Connection connection = null;
		
		try {
			ServeiWebServiceLocator service = new ServeiWebServiceLocator();
			ServeiWeb port;
			port = service.getServeiWebPort();
			
			int tipoLocal = Integer.parseInt(request.getParameter("tipoLocal"));	
			
			System.out.println("Local type: "+ tipoLocal);
			
			Formulari formulari = port.getFormulariByLocalType(tipoLocal, "ca");
			System.out.println(formulari);
			
			//Local local = port.getLocalByAdressOrName(tipusVia,nomCarrer,numero,nomLocal,idioma);

			session = request.getSession(true);		
			session.setAttribute("tipoLocal", tipoLocal);
			session.setAttribute("formulari", formulari);

			
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/addLocal");
			rd.forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServiceException e2) {
			e2.printStackTrace();
		}		
	}
}
