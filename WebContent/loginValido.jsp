<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Login Válido</title>
	</head>
	<body>
		<h1>Login Válido</h1>
<%
System.out.println("Dentro de loginValido.jsp");
String usuario = (String) session.getAttribute("usuario");
String sessionid = (String) session.getId();
/* String nombreUsuario = null;
String idSession = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("usuario")) nombreUsuario = cookie.getValue();
		if(cookie.getName().equals("JSESSIONID")) idSession = cookie.getValue();
	}
} */
%>
		<h3>Saludos <%=usuario %></h3>
		<p>Entrada Validada. su identificador de session es... <%=sessionid %></p>
		<%-- <p>Usuario=<%=usuario %></p>
		<p>SessionId=<%=sessionid %></p> --%>
		<br>
		<a href="checkOut.jsp">Checkout Page</a>
		<form action="logout" method="post">
			<input type="submit" value="Logout" >
		</form>
	</body>
</html>