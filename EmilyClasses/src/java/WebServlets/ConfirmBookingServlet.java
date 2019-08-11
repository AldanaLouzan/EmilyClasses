package WebServlets;



import WebUtil.Errors;
import WebUtil.Pages;
import WebUtil.UIConstants;
import bookingclass.controller.BookingController;
import bookingclass.controller.ClassController;
import bookingclass.controller.MenuController;
import bookingclass.entity.Classes;
import bookingclass.entity.Slot;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConfirmBookingServlet",urlPatterns = {"/ConfirmBookingServlet"})
public class ConfirmBookingServlet extends HttpServlet {

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
        String jspPage = Pages.CONFIRMBOOKING;
        List<String> errorList = new ArrayList<String>();
        PrintWriter out = response.getWriter();
        
        MenuController mc = new MenuController();
        BookingController bc = new BookingController();
        HttpSession session= (HttpSession) request.getSession();
        
        Classes c = (Classes)session.getAttribute("classSet");
        Slot s = (Slot)session.getAttribute("slotSet");
        
        boolean success = mc.confirmBooking(c, s);
        ResultSet rs = bc.getAllBookings();
        session.setAttribute("bookingsResultSet", rs);
                
        if (!success){
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'><</script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ( 'Oops!' ,  'Something went wrong, please try again' ,  'success' )");
            out.println("});");
            out.println("</script>");
            
            errorList.add(Errors.ERROR_LOGIN);
            request.setAttribute(UIConstants.ERROR_LIST, errorList); 
        }else{
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'><</script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ( 'Well done' ,  'Your booking was successfull' ,  'success' )");
            out.println("});");
            out.println("</script>");
            
            jspPage = Pages.MYACCOUNT;
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
