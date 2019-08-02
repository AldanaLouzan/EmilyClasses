package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Classes;
import iDao.IClassesDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Eoin
 */
public class ClassesDaoImpl implements IClassesDao {

  PreparedStatement pst;
    Statement st;
    ResultSet rs;

    //Obtain time available for classes type = private or type = in-group 
    public ArrayList<Classes> selectEmptyClass(Date d) {
        ArrayList<Classes> classAvailable = new ArrayList();

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        LocalDate choosenDate = LocalDate.of(year, month, date);

        Connection con = null;

        String sql = "SELECT * "
                + "FROM classes "
                + "WHERE type = 'empty' "
                + "AND date = '" + choosenDate + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Classes c = new Classes();
                c.setId(rs.getInt(1));
                c.setDate(rs.getDate(2));
                c.setTime(rs.getInt(3));
                c.setType(rs.getString(4));
                c.setQuantityStudents(rs.getInt(5));

                classAvailable.add(c);
            }
            //con.commit();
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        return classAvailable;

    }

    //Obtain time available for classes type = private or type = in-group 
    public ArrayList<Classes> selectSemiprivateClass(Date d) {
        ArrayList<Classes> classAvailable = new ArrayList();

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        LocalDate choosenDate = LocalDate.of(year, month, date);

        Connection con = null;

        String sql = "SELECT * "
                + "FROM classes "
                + "WHERE type = 'empty' "
                + "OR (type = 'semiprivate' AND quantity_students < 4) "
                + "AND date = '" + choosenDate + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Classes c = new Classes();
                c.setId(rs.getInt(1));
                c.setDate(rs.getDate(2));
                c.setTime(rs.getInt(3));
                c.setType(rs.getString(4));
                c.setQuantityStudents(rs.getInt(5));

                classAvailable.add(c);
            }
            //con.commit();
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        return classAvailable;

    }

    public void book(Classes c) {
        Connection con = null;

        String sql = "UPDATE classes "
                + "SET type = '" + c.getType() + "'"
                + "WHERE idclasses = "+c.getId();
        try {
            con = getConnection();
            pst = con.prepareStatement(sql);

            //pst.setString(1, c.getType());
            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }
    public int checkQuantityStudents (int classID){
        Connection con = null;
        int quantityStudents = 0;
        
        String sql = "SELECT quantity_students "
                + "FROM classes "
                + "WHERE idclasses = '"+classID+"';";
        
        try{
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
        while (rs.next()){
                quantityStudents = rs.getInt("quantity_students");

                
                
            }    
con.close();
            
            
        }catch (Exception e) {
            System.err.println(e);
        }
        return quantityStudents;
            
        
        
    }
    
    public void insertQuantityStudents(Classes c, int qs){
         Connection con = null;

        String sql = "UPDATE classes "
                + "SET quantity_students = '" + qs + "'"
                + "WHERE idclasses = "+c.getId();
        try {
            con = getConnection();
            pst = con.prepareStatement(sql);

            //pst.setString(1, c.getType());
            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }


}
