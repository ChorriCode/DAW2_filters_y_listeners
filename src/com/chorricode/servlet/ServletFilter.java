package com.chorricode.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ServletFilter
 */
/*@WebFilter("/*")*/
@WebFilter("/ServletLogin")
public class ServletFilter implements Filter {

	private ServletContext context;
	
    /**
     * Default constructor. 
     */
    public ServletFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("========== Dentro de doFilter ==========");
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			System.out.println("Revisando parámetros del request en doFilter:");
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(req.getRemoteAddr() + "::Request Params::{" + name + "=" + value + "}");
			System.out.println(req.getRemoteAddr() + "::Request Params::{" + name + "=" + value + "}");
			System.out.println();
		}
		/*
		Cookie [] cookies = req.getCookies();
		if (cookies != null) {
			System.out.println("Revisando cookies en doFilter:");
			for (Cookie cookie : cookies) {
				this.context.log(req.getRemoteAddr() + "::Cookie::{" + cookie.getName() + "," + cookie.getValue() + "}");
				System.out.println(req.getRemoteAddr() + "::Cookie::{" + cookie.getName() + "," + cookie.getValue() + "}");
				System.out.println();
			}
		Arrays.asList(cookies).forEach(listItem -> {System.out.println("En doFilter: " + listItem.getName() + " : " + listItem.getValue());});
		}
		*/
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("========== Saliendo de doFilter ==========");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Login Filter Inicializado");
		System.out.println("Login Filter Inicializado");
		System.out.println();
	}

}
