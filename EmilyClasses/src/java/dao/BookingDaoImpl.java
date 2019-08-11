package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Booking;
import bookingclass.entity.Classes;
import bookingclass.entity.Parent;
import bookingclass.entity.Slot;
import bookingclass.entity.Student;
import bookingclass.entity.Teacher;
import iDao.IBookingDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;


public class BookingDaoImpl implements IBookingDao{
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    
    public Booking getBooking(int bookingId) {
        Booking bok = null;
        Student stu = new Student();        
        Classes c = new Classes(); 
        Slot sl = new Slot();
        //Fields IDs
        int idclass = 0;
        int idslot = 0;
        int idstudent = 0;
        
        Connection con = null;
        String sql = "SELECT "
                + "idclass, idslot, idstudent "
                + "FROM booking "
                + "WHERE idbooking = '" + bookingId + "';";
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idclass = rs.getInt("idclass");
                idslot = rs.getInt("idslot");
                idstudent = rs.getInt("idstudent");
            }
            //Set IDs
            stu.setId(idstudent);
            c.setId(idclass);
            sl.setIdSlot(idslot);
            
            bok = new Booking(c,sl,stu);
            
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return bok;
    }
    
    public boolean insertNewBooking(Classes c, Slot sl, Student stu){
        boolean value;
        Connection con = null;
        
        String sql = "INSERT INTO booking (date, time, type, quantity_students, s_name, s_surname, subject, price, idclass, idslot, idstudent) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        //Set Classes.getDate in the correct format YYYY-MM-DD for Prepared Statement "pst" pst.setDate      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateAsString = sdf.format(c.getDate());

        try {
            
            con = getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, dateAsString);
            pst.setInt(2, c.getTime());
            pst.setString(3, c.getType());
            pst.setInt(4, c.getQuantityStudents());
            pst.setString(5, stu.getName());
            pst.setString(6, stu.getSurname());
            pst.setString(7, sl.getSubject());
            pst.setInt(8, sl.getPrice());
            pst.setInt(9, sl.getClasses().getId());
            pst.setInt(10, sl.getIdSlot());
            pst.setInt(11, sl.getStudentID());
            
            int res = pst.executeUpdate();

            if (res > 0) {
                System.out.println("You have a new Booking registered");
                value = true;
            } else {
                System.out.println("Error");
                value = false;
            }

            con.close();
            return value;

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public ResultSet getAllBookings() {
        Connection con = null;
        String sql = "SELECT * " 
                + "FROM booking ;";
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            //con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return rs;
    }
    
    public ResultSet getAllBookingsByUser(int idStudent) {
        Connection con = null;
        String sql = "SELECT * " 
                + "FROM booking ;";
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            //con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return rs;
    }
    
}
