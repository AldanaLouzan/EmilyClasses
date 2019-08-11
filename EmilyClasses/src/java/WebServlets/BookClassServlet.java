package WebServlets;

import WebUtil.Pages;
import WebUtil.UIConstants;
import bookingclass.controller.ClassController;
import bookingclass.controller.SlotController;
import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BookClassServlet", urlPatterns = {"/BookClassServlet"})
public class BookClassServlet extends HttpServlet {

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
        Classes newClass = new Classes();
        Slot newSlot = new Slot();
        ClassController cc = new ClassController();
        SlotController sc = new SlotController();
        HttpSession session= (HttpSession) request.getSession(true);
        
        String classId = request.getParameter(UIConstants.CID); //Get ClassId of the time chosen
        int id = Integer.parseInt(classId);
        newClass.setId(id);
        
        String date = (String)session.getAttribute("classDate");    //Get ClassDate
        newClass.setDate(Date.valueOf(date));

        newClass.setType((String)session.getAttribute("classType"));
        newClass.setTime(cc.selectTime(newClass.getId()));
        session.setAttribute("classTime", newClass.getTime());
                
        int prevQuantStudents = cc.previousQuantityStudents(newClass.getId()); //get quantitystudents of the class
        int quantityStudents =  cc.quantityStudents(newClass.getType(), 0, prevQuantStudents);
        newClass.setQuantityStudents(quantityStudents);
        session.setAttribute("quantityStudents", quantityStudents);
        
        String comment = (String)session.getAttribute("slotComment");
        String subject = (String)session.getAttribute("slotSubject");
        
        newSlot = sc.booking(newClass, (Integer)session.getAttribute("studentId"), subject , comment);
        int slotPrice = newSlot.getPrice();
        session.setAttribute("slotPrice", slotPrice);
        
        session.setAttribute("classSet", newClass);
        session.setAttribute("slotSet", newSlot);
        
        response.sendRedirect(request.getContextPath()+"/confirmBooking.jsp");
        
        
        
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
