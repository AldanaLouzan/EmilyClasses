package WebServlets;

import WebUtil.Pages;
import bookingclass.controller.SlotController;
import bookingclass.entity.Slot;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyBookingsServlet", urlPatterns = {"/MyBookingsServlet"})
public class MyBookingsServlet extends HttpServlet {

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
        /*ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2"); 
        ResultSetMetaData rsmd = rs.getMetaData(); 
        String name = rsmd.getColumnName(1); */
        String jspPage = Pages.LISTBOOKINGS;
        List<String> errorList = new ArrayList<String>();
        SlotController sl = new SlotController();
        Date d = null;
        d.setDate(23);
        d.setMonth(7);
        d.setYear(2019);
        ResultSet rs = sl.selectSlotJoinClasses(d); 
        Object[] algo = rs.next();
        ResultSetMetaData rsmd = rs.getMetaData();
        // better add performance
        List<Object[]> records=new LinkedList<Object[]>();
        // call only once
        int cols = rsmd.getColumnCount();
        
        while(rs.next()){
            Object[] arr = new Object[cols];
            for(int i=0; i<cols; i++){
              arr[i] = rs.getObject(i+1);
            }
            records.add(arr);
        }
        
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
