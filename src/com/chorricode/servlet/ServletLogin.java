package com.chorricode.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.session.StandardSession;
import org.apache.catalina.session.StandardSessionFacade;

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
		System.out.println("========== Dentro de ServletLogin ==========");
		// recogemos los datos del formulario login.html
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		// validamos que los datos sean corrector para crear una Sesión
		if (usuario.equals(idUsuarioValida) && clave.equals(claveValida)) {
			System.out.println("Dentro de doPost ServletLogin: DATOS CORRECTOS");		
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", "principal");
			System.out.println("session.getId(): " + session.getId());      
			Cookie[] cookies = request.getCookies();
			Cookie nombreUsuario = new Cookie("usuario", usuario);
			/*
			Cookie [] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				System.out.println(request.getRemoteAddr() + "::Cookie::{" + cookie.getName() + "," + cookie.getValue() + "}");
				System.out.println();
			}
			*/	
			response.addCookie(nombreUsuario);		
			response.sendRedirect("loginValido.jsp");
			//getServletContext().getRequestDispatcher("/loginValido.jsp").forward(request, response);
			System.out.println("==================");
			//Arrays.asList(cookies).forEach(listItem -> {System.out.println("En ServletLogin: " + listItem.getName() + " : " + listItem.getValue());});
		} else {
			// si los datos no son correctos regresamos a login.html
			System.out.println("Dentro de doPost ServletLogin: DATOS NO CORRECTOS");
			getServletContext().getRequestDispatcher("/login.html").forward(request, response);
		}
		System.out.println("========== Saliendo de ServletLogin ==========");
	}

}
