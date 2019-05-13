package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import serveiWebSOAP.Local;
import serveiWebSOAP.ServeiWeb;
import serveiWebSOAP.ServeiWebServiceLocator;

/**
 * Servlet implementation class LocalServlet
 */
@WebServlet("/LocalServlet")
public class LocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doFer(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doFer(request, response);
	}
	
	private void doFer(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sessio;
		Connection connection = null;
		
		try {
			ServeiWebServiceLocator service = new ServeiWebServiceLocator();
			ServeiWeb port;
			port = service.getServeiWebPort();
			
			String action = (String)request.getParameter("action");
			String tipusVia = (String)request.getParameter("tipusVia");
			String nomCarrer = (String)request.getParameter("nomCarrer");
			int numero = Integer.parseInt((String)request.getParameter("numero"));
			String nomLocal = (String)request.getParameter("nomLocal");
			String idioma = (String)request.getParameter("idioma");
			String tipus_busqueda = (String)request.getParameter("tipus_busqueda");
			

			Local local = port.getLocalByAdressOrName(tipusVia,nomCarrer,numero,nomLocal,idioma);

			sessio = request.getSession(true);		
			sessio.setAttribute("Local", local);
			sessio.setAttribute("action", action);
			sessio.setAttribute("tipus_busqueda",tipus_busqueda);
			
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/index");
			rd.forward(request, response);
			
		} catch (ServletException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}catch (ServiceException e2) {
			e2.printStackTrace();
		}
		
		
		
	}
	

}
