package com.chorricode.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ServletLogOut
 */
@WebServlet("/logout")
public class ServletLogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogOut() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========== Dentro de ServletLogOut ==========");
		System.out.println();
		response.setContentType("text/html");
		/*
    	Cookie[] cookies = request.getCookies();
    	if (cookies != null) {
    		for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					System.out.println("JSESSIONID= " + cookie.getValue());
					cookie.setValue("");
		            cookie.setPath("/");
		            cookie.setMaxAge(0);
		            response.addCookie(cookie);
					break;
				}
			}
    		Cookie cookie = new Cookie("JSESSIONID", null);
    		cookie.setValue(null);
    		cookie.setMaxAge(0);
    		cookie.setPath("/");
    		response.addCookie(cookie);
    	}
*/
		Cookie[] cookies = request.getCookies();
		Arrays.asList(cookies).forEach(listItem -> {System.out.println(listItem.getName() + " : " + listItem.getValue());});
		System.out.println("cookie[0].getName(): " + cookies[0].getName());
		System.out.println("cookie[0].getValue(): " + cookies[0].getValue());
		System.out.println("cookie[1].getName(): " + cookies[1].getName());
		System.out.println("cookie[1].getValue(): " + cookies[1].getValue());
		
    	// invalidamos sesión si existe
    	HttpSession session = request.getSession(false);
    	System.out.println("session.getAttribute(\"usuario\"): " + session.getAttribute("usuario"));
    	if (session != null) {
    		session.invalidate();
    	}
    	System.out.println("redirecting to "+request.getContextPath());
        response.sendRedirect(request.getContextPath());
    	//response.sendRedirect("login.html");
        
        System.out.println("========== Saliendo de ServletLogOut ==========");
	}

}
