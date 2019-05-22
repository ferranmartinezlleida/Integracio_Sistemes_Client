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
import serveiWebSOAP.*;


/**
 * Servlet implementation class AddLocalServlet
 */
@WebServlet("/AddLocalServlet")
public class AddLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLocalServlet() {
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
		
		try {
			ServeiWebServiceLocator service = new ServeiWebServiceLocator();
			ServeiWeb port;
			port = service.getServeiWebPort();
			session = request.getSession(true);
			
			// Get parameter
			String nomLocal = (String)request.getParameter("nomLocal");	
			String nomCarrer = (String)request.getParameter("nomCarrer");	
			int codiCarrer = Integer.parseInt(request.getParameter("codiCarrer"));	
			String nomVia = (String)request.getParameter("nomVia");	
			int numero = Integer.parseInt(request.getParameter("numero"));	
			String observacions = (String)request.getParameter("observacions");	
			
			// Get attribute
			int tipoLocal = (int) session.getAttribute("tipoLocal");
			Caracteristica[] caracteristiques = (Caracteristica[]) session.getAttribute("caracteristiques");
			String idioma = (String) session.getAttribute("idioma");
			
			// Set Local fields
			Local local = new Local();
			local.setCodiTipoLocal(tipoLocal);
			local.setNomLocal(nomLocal.toUpperCase());
			local.setNomCarrer(nomCarrer.toUpperCase());
			local.setCodiCarrer(codiCarrer);
			local.setNomVia(nomVia);
			local.setNumero(numero);
			local.setObservacions(observacions);
			
			Formulari form = new Formulari();
			form.setCodiTipoLocal(tipoLocal);
			form.setIdioma(idioma);
		   
			
			for(Caracteristica ca: caracteristiques) {
				ca.setValor(Integer.parseInt(request.getParameter("caracteristica_" + ca.getCodiCaracteristica())));
			}
			
			form.setCaracteristiques(caracteristiques);
			local.setForm(form);
			
			// Add Local
			boolean status = port.addLocal(local);
			session.setAttribute("status", status);
			
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/savedLocal.jsp");
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
