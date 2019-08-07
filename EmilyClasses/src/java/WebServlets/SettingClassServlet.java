package WebServlets;

import WebUtil.Errors;
import WebUtil.Pages;
import WebUtil.UIConstants;
import bookingclass.controller.ClassController;
import bookingclass.controller.MenuController;
import bookingclass.entity.Classes;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SettingClassServlet", urlPatterns = {"/SettingClassServlet"})
public class SettingClassServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(String jsp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (jsp != null) {
        	
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            
            try {
                rd.forward(request, response);
            } catch (IOException e) {
                throw new ServletException(e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MenuController mc = new MenuController();
        ClassController cc = new ClassController();
        Classes c = new Classes();
        
        HttpSession session = request.getSession(true);
        
        c.setType((String) request.getParameter(UIConstants.CTYPE));
        //int groupQuantity = Integer.parseInt((String) request.getParameter(UIConstants.GROUPQUANTITY));

        session.setAttribute("classType", c.getType());
        session.setAttribute("classDate", (String) request.getParameter(UIConstants.CDATE));
        //session.setAttribute("groupQuantity", groupQuantity);
        session.setAttribute("slotSubject", (String) request.getParameter(UIConstants.SSUBJECT));
        session.setAttribute("slotComment", (String) request.getParameter(UIConstants.SCOMMENT));

        response.sendRedirect(request.getContextPath()+"/bookClass.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
