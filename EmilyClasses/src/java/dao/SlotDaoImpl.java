package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Classes;
import bookingclass.entity.Parent;
import bookingclass.entity.Slot;
import bookingclass.entity.Student;
import bookingclass.entity.Teacher;
import iDao.ISlotDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SlotDaoImpl implements ISlotDao {
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    
       @Override
    public boolean insertNewSlot (Slot s){
        boolean value;
        Connection con = null;
        
        String sql = "INSERT INTO slot (idclasses, idstudent, comment, price, status, subject) "
                + "VALUES(?,?,?,?,?,?)";

        try {
            
            con = getConnection();
            pst = con.prepareStatement(sql);

            pst.setInt(1, s.getClasses().getId());
            pst.setInt(2, s.getStudentID());
            pst.setString(3, s.getComment());
            pst.setInt(4, s.getPrice());
            pst.setString(5, s.getStatus());
            pst.setString(6, s.getSubject());
            
            int res = pst.executeUpdate();

            if (res > 0) {
                System.out.println("You have been registered");
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

    public Slot getSlot(int slotId) {
        Slot sl = null;
        Classes c = new Classes();
        //Fields
        int idstudent = 0;
        int idclass = 0;
        String subject = null;
        int price = 0;
        String status = null;
        String comment = null;
                     
        Connection con = null;
        String sql = "SELECT "
                + "idclasses,  idstudent, comment, price, status, subject "
                + "FROM slot "
                + "WHERE idslot = '" + slotId + "';";
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idclass = rs.getInt("idclasses");
                idstudent = rs.getInt("idstudent");
                comment = rs.getString("comment");
                price = rs.getInt("price");
                status = rs.getString("status");
                subject = rs.getString("subject");
            }
            //Set ID
            c.setId(idclass);
          
            sl = new Slot(slotId, idstudent, subject, price, status, c, comment);
            
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return sl;
    }
    
    @Override
    public ResultSet selectSlotJoinClasses(Date d) {
        Connection con = null;
        
        String sql = "SELECT c.date, c.time, c.type, c.quantity_students, stu.s_name, stu.s_surname, sl.subject, sl.price " + 
        "FROM slot sl " +
        "INNER JOIN classes c on sl.idclasses=c.idclasses " +
        "INNER JOIN student stu on sl.idstudent=stu.idstudent " + 
        "WHERE c.date= '" + d + "' " +
        "ORDER BY c.time";
        
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
        } catch (Exception e) {
            System.err.println(e);
        }
        return rs;
    }
    
    public int getIdSlotByParameters(Slot s) {
        Slot sl = null;
        Classes c = new Classes();
        //Fields
        int idslot = 0;
        int idclass = 0;
        String subject = null;
        int price = 0;
        String status = null;
        String comment = null;
                     
        Connection con = null;
        String sql = "SELECT idslot "
                + "FROM slot "
                + "WHERE idclasses = '" + s.getClasses().getId() + "' and idstudent = '"+ s.getStudentID() + "' and comment = '" + s.getComment() + "' and price = '" + s.getPrice() + "' and status = '" + s.getStatus() + "' and subject = '" + s.getSubject() + "';";
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                idslot = rs.getInt("idslot");
            }
                        
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return idslot;
    }    
    
}
