package WebServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import WebUtil.*;
import bookingclass.entity.*;
import viewInterface.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import WebCliente.*;
import bookingclass.controller.MenuController;
import bookingclass.controller.StudentController;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param jsp
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
        StudentController sc = new StudentController();
        String jspPage = Pages.INDEX;
        List<String> errorList = new ArrayList<String>();
        User user = new User();
        HttpSession session= (HttpSession) request.getSession(true);
        
        
        user.setEmail((String) request.getParameter(UIConstants.USUARIO));
        user.setPassword((String) request.getParameter(UIConstants.PASSWORD));
                
        int value = mc.login(user.getEmail(), user.getPassword());
        if (value == 1){
            jspPage = Pages.TEACHERACCOUNT;
        } else if (value == 2){
                int studentid = sc.checkStudentId(user.getEmail());
                String studentName = sc.checkStudentName(studentid) ;
                session.setAttribute("studentId", studentid);
                session.setAttribute("studentName", studentName);
                jspPage = Pages.HOME;
            }else{
                errorList.add(Errors.ERROR_LOGIN);
                request.setAttribute(UIConstants.ERROR_LIST, errorList);  
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
