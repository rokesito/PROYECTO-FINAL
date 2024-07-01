<%-- 
    Document   : Inicio
    Created on : 30/06/2024, 12:56:32 PM
    Author     : roke
--%>

<%
    String cookieName = "visitorName";
    Cookie[] cookies = request.getCookies();
    boolean existeCookie = false;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                existeCookie = true;
            }
        }
    }

    if (existeCookie) {
        response.sendRedirect("Visitante.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bienvenido</title>
</head>
<body>
<h1>Hola</h1>
<p>Es tu primera vez en el sitio :3</p>

<form action="<%=request.getContextPath() %>/Inicio" method="POST">
    <p>
        ¿Cómo te llamas?
        <input type="text" name="nombre"/>
        <input type="submit" value="responder"/>
    </p>
</form>
</body>
</html>