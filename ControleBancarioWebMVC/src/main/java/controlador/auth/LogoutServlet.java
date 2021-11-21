package controlador.auth;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("usuarioAutenticado") != null &&
				"OK".equals(session.getAttribute("usuarioAutenticado"))) {
			request.setAttribute("tituloPagina", "Sair");
			request.setAttribute("pathView", "WEB-INF/views/auth/logout.jsp");
		} else {
			request.setAttribute("tituloPagina", "Sistema de Controle Bancario Web - Pagina "
					+ "Inicial");
			request.setAttribute("pathView", "WEB-INF/index.jsp");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("usuarioAutenticado") != null &&
				"OK".equals(session.getAttribute("usuarioAutenticado"))) {
			session.removeAttribute("usuarioAutenticado");
			session.removeAttribute("usuario");
		} 
		
		request.setAttribute("tituloPagina", "Sistema de Controle Bancario Web - Pagina "
				+ "Inicial");
		request.setAttribute("pathView", "WEB-INF/index.jsp");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/template.jsp");
		rd.forward(request, response);
	}

}
