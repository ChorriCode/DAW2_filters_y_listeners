package com.chorricode.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//datos validos para el login (simula que estuviesen almacenados en una BBDD)
	private final String idUsuarioValida = "admin";
	private final String claveValida = "password";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recogemos los datos del formulario login.html
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		// validamos que los datos sean corrector para crear una Sesión
		if (usuario.equals(idUsuarioValida) && clave.equals(claveValida)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", "principal");
			Cookie nombreUsuario = new Cookie("usuario", usuario);
			response.addCookie(nombreUsuario);
			response.sendRedirect("jsp/loginValido.jsp");
		} else {
			// si los datos no son correctos regresamos a login.html
			getServletContext().getRequestDispatcher("/login.html").forward(request, response);
		}
	}

}
