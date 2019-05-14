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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doFer(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doFer(request, response);
	}
	
	
	private void doFer(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session;
		Connection connection = null;
		
		try {
			ServeiWebServiceLocator service = new ServeiWebServiceLocator();
			ServeiWeb port;
			port = service.getServeiWebPort();
			session = request.getSession(true);
			
			int tipoLocal = Integer.parseInt(request.getParameter("tipoLocal"));	

			
			String nomLocal = (String)request.getParameter("nomLocal");	
			String nomCarrer = (String)request.getParameter("nomCarrer");	
			int codiCarrer = Integer.parseInt(request.getParameter("codiCarrer"));	
			String nomVia = (String)request.getParameter("nomVia");	
			int numero = Integer.parseInt(request.getParameter("numero"));	
			String observacions = (String)request.getParameter("observacions");	

			System.out.println("tipoLocal: " + tipoLocal);
			System.out.println("nomLocal: " + nomLocal);
			System.out.println("nomCarrer: " + nomCarrer);
			System.out.println("codiCarrer: " + codiCarrer);
			System.out.println("nomVia: " + nomVia);
			System.out.println("numero: " + numero);
			System.out.println("observacions: " + observacions);
			
			Local local = new Local();
			local.setCodiTipoLocal(tipoLocal);
			local.setNomLocal(nomLocal);
			local.setNomCarrer(nomCarrer);
			local.setCodiCarrer(codiCarrer);
			local.setNomVia(nomVia);
			local.setNumero(numero);
			local.setObservacions(observacions);
			
			Formulari form = new Formulari();
			Caracteristica[] caracteristiques = (Caracteristica[]) session.getAttribute("caracteristiques");
			form.setCodiTipoLocal(tipoLocal);
			form.setIdioma("ca");
		   
			int value = 0;
			for(Caracteristica ca: caracteristiques) {
				value = Integer.parseInt(request.getParameter("caracteristica_" + ca.getCodiCaracteristica()));	
				ca.setValor(value);
			}
			form.setCaracteristiques(caracteristiques);
			local.setForm(form);
			
			boolean status = port.addLocal(local);
			session.setAttribute("status", status);


			
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/savedLocal.jsp");
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
