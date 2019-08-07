package dao;

import static bookingclass.connectionDb.DBConnection.getConnection;
import bookingclass.entity.Teacher;
import iDao.ITeacherDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacherDaoImpl implements ITeacherDao {

    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    public boolean insertTeacher(Teacher t) {
        Connection con = null;
        boolean value;

        String sql = "INSERT INTO teacher (t_name, t_surname, t_email, t_password, t_phone) "
                + "VALUES(?,?,?,?,?)";

        try {

            con = getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, t.getName());
            pst.setString(2, t.getSurname());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getPassword());
            pst.setString(5, t.getPhone());

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

    public boolean checkUser(String email) {
        Connection con = null;
        String registeredUser = null;

        String sql = "SELECT t_email "
                + "FROM teacher "
                + "WHERE t_email = '" + email + "';";

        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                registeredUser = rs.getString("t_email");
                if (registeredUser != null) {
                    return true;
                } else {
                    con.close();
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;

    }
    
    //Request password
    public String checkPass (String email){
        Connection con = null;
        String pass = null;
       
        String sql = "SELECT t_password "
                + "FROM teacher "
                + "WHERE t_email = ?";
        
        try{
            con = getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            
        while (rs.next()){
                pass = rs.getString("t_password");
        }

        con.close();
            
        }catch (Exception e) {
            System.err.println(e);
        }
        return pass;
            
    }

}
