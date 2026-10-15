package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet RecibeDatos - recibe usuario y clave desde index.html y valida.
 */
public class RecibeDatos extends HttpServlet {

    /**
     * Arma la pagina HTML de respuesta con el mensaje recibido.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecibeDatos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecibeDatos at " + msg + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Atiende formularios con method="get": lee usuario y clave y valida.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("usuario");
        String pass = request.getParameter("clave");
        if ("admin".equals(user) && "1234".equals(pass)) {
            processRequest(request, response, "Registro Exitoso");
        } else {
            processRequest(request, response, "Registro Invalido");
        }
    }

    /**
     * Atiende formularios con method="post": delega en doGet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Descripcion corta del servlet.
     */
    @Override
    public String getServletInfo() {
        return "Servlet RecibeDatos - valida usuario y clave del formulario";
    }
}
