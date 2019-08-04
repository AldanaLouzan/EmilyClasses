package WebServlets;

import WebUtil.Errors;
import WebUtil.Pages;
import WebUtil.UIConstants;
import bookingclass.controller.MenuController;
import bookingclass.controller.StudentController;
import bookingclass.entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        //MenuController mc = new MenuController();
        StudentController sc = new StudentController();
        String jspPage = Pages.REGISTER;
        List<String> errorList = new ArrayList<String>();
                
        Student user = new Student();
        
        user.setName((String) request.getParameter(UIConstants.STNAME));
        user.setSurname((String) request.getParameter(UIConstants.STSURNAME));
        user.setPhone((String) request.getParameter(UIConstants.STPHONE));
        user.setBirth((String) request.getParameter(UIConstants.STBIRTH));
        user.setEmail((String) request.getParameter(UIConstants.USUARIO));
        user.setPassword((String) request.getParameter(UIConstants.PASSWORD));
        user.setCollege((String) request.getParameter(UIConstants.STCOLLEGE));
        user.setLevel((String) request.getParameter(UIConstants.STLEVEL));
        /*
        user.setEmail((String) request.getParameter(UIConstants.));
        user.setEmail((String) request.getParameter(UIConstants.USUARIO));
        user.setEmail((String) request.getParameter(UIConstants.USUARIO));
        */
        try{
           int age = sc.CalculateAge(user.getBirth());
           user.setAge(age);
        }catch(Exception e){
            System.err.println(e);
        }
        
        boolean success = sc.registerStudent(user);
        
        if (!success) {
                errorList.add(Errors.ERROR_STUDENT_REGISTRATION);
                request.setAttribute(UIConstants.ERROR_LIST, errorList);
        } else {
                jspPage = Pages.INDEX;
        }
				
        processRequest(jspPage, request, response);
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
