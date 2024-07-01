package hola;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adios", urlPatterns = {"/adios"})
public class adios extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Crear una cookie
        Cookie myCookie = new Cookie("user", "Rogelio");
        // Establecer el tiempo de vida de la cookie en segundos
        myCookie.setMaxAge(60*60*24); // 1 día
        // Agregar la cookie a la respuesta
        response.addCookie(myCookie);

        // Leer cookies
        Cookie[] cookies = request.getCookies();
        String user = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    user = cookie.getValue();
                }
            }
        }

        // Escribir una respuesta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (user != null) {
            out.println("<h1>Hola, " + user + "!</h1>");
        } else {
            out.println("<h1>No se encontró la cookie 'user'.</h1>");
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Procesar la solicitud POST
        doGet(request, response);
    }
}
