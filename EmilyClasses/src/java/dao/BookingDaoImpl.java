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
                + "idclass, idslot, idstudent"
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
}
