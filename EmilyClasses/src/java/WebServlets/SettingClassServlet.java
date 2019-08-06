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
    
    //public Classes c = new Classes();
    //public ResultSet rs;

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
        response.setContentType("text/html;charset=UTF-8");
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
        doPost(request, response);
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
        //StudentController sc = new StudentController();
        String jspPage = Pages.CLASSSETTING;
       
        List<String> errorList = new ArrayList<String>();
        
        //Student user = new Student();
        Classes c = new Classes();
        
        c.setType((String) request.getParameter(UIConstants.CTYPE));
        int groupQuantity = Integer.parseInt((String) request.getParameter(UIConstants.GROUPQUANTITY));
        c.setQuantityStudents(cc.quantityStudents(c.getType(), 0));
        try {
            c.setDate(mc.chooseDate((String) request.getParameter(UIConstants.CDATE)));
        } catch (ParseException ex) {
            Logger.getLogger(SettingClassServlet.class.getName()).log(Level.SEVERE, null, ex);
        }        
        int classID = cc.classId((String) request.getParameter(UIConstants.CID));
        c.setId(classID);
        //c.setTime(cc.selectTime(c));
        
        HttpSession session = request.getSession();
        session.setAttribute("classSet", c);
  
        /*boolean success = sc.registerStudent(user);
        
        if (!success) {
                errorList.add(Errors.ERROR_BOOK_CLASS);
                request.setAttribute(UIConstants.ERROR_LIST, errorList);
        } else {
                jspPage = Pages.HOME;
        }
				*/
        //processRequest(jspPage, request, response);
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
