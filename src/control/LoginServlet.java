package control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import metier.MetierJPA;
import model.Client;
import util.Catalog;


@WebServlet("/process")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Navigation 
    private void forward(String url, HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);

    }

    // Controleur
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // R�cup�ration de l'action
            String action = request.getParameter("action");

            // Ex�cution du traitement associ� � cette action
            if (action.equals("init")) {
                doInit(request, response);
            } else if (action.equals("login")) {
                doLogin(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void doInit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (this.getServletContext().getAttribute("items") == null) {
            Catalog catalog = MetierJPA.getSingleton().getCatalog();
            this.getServletContext().setAttribute("items", catalog);
        }
        String url = "pages/login.jsp";
        forward(url, request, response);
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nom = request.getParameter("nom");
            String motdepasse = request.getParameter("motdepasse");

            Client client = MetierJPA.getSingleton().findByNomandPassword(nom, motdepasse);
            String url = "pages/catalog.jsp";
            forward(url, request, response);
        }  /*todo faire une page de redirection error*/ catch (Exception e) {
            e.printStackTrace();
        }
    }
}
