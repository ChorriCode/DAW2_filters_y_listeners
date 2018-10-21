<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Out</title>
</head>
<body>
<h1>Login Out</h1>
<%
String nombreUsuario = null;
String idSession = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("usuario")) nombreUsuario = cookie.getValue();
	}
}
%>
<h3>Saludos <%=nombreUsuario %>, puedes cerrar la sessión.</h3>
<br>
<form action="logout" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>