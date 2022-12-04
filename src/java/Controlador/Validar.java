package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Aylin Camila Orjuela Leiva & Juan Pablo Cuellar Florez
 */
public class Validar extends HttpServlet {

    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    Statement stm;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        
        switch(accion){
            case "Ingresar":
                String m = request.getParameter("txtuser");
                String p = request.getParameter("txtpass");
                EmpleadoDAO dao = new EmpleadoDAO();
                Empleado em = dao.validar(m, p);
                if(em!=null){ //si hay sesion
                    System.out.println("ok entro a sesion");
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", em);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);//redireccionar
                }else{
                    System.out.println("NO hay sesion");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
            case "Salir":
                
                break;
            default:
                System.out.println("Error al ingresar clase processRequest.");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
